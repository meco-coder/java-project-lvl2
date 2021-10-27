package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        String formatFile = formatFile(filePath1);
        String dataFromFile1 = readFile(filePath1);
        String dataFromFile2 = readFile(filePath2);
        TreeMap<String, Object> mapFile1 = parse(dataFromFile1, formatFile);
        TreeMap<String, Object> mapFile2 = parse(dataFromFile2, formatFile);
        TreeSet<String> sortedKeyFile1AndFile2 = setKeys(mapFile1, mapFile2);
        TreeMap<String, Map<String, ArrayList<Object>>> resultDifferFile1AndFile2 = createDiff(sortedKeyFile1AndFile2,
                mapFile1, mapFile2);

        return Formatter.format(resultDifferFile1AndFile2, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String readFile(String fileName) throws IOException {
        String dataToString = "";
        Path fileForParse = Paths.get(fileName).normalize()
                .toAbsolutePath();
        dataToString = Files.readString(fileForParse);
        return dataToString;
    }


    public static TreeMap<String, Object> parse(String dataFromFile, String formatFile)
            throws IOException {
        Parser parse = new Parser();
        return parse.parse(dataFromFile, formatFile);
    }

    public static TreeSet<String> setKeys(TreeMap<String, Object> mapFile1, TreeMap<String, Object> mapFile2) {
        Set<String> setKeysFilePath1 = mapFile1.keySet();
        Set<String> setKeysFilePath2 = mapFile2.keySet();
        TreeSet<String> sortedKeysFile1AndFile2 = new TreeSet<>(setKeysFilePath1);
        sortedKeysFile1AndFile2.addAll(setKeysFilePath2);
        return sortedKeysFile1AndFile2;
    }

    public static String formatFile(String file) {
        return !file.endsWith(".json") ? "yml" : "json";
    }

    public static TreeMap<String, Map<String, ArrayList<Object>>> createDiff(TreeSet<String> sortedFile1AndFile2,
                                                                             TreeMap<String, Object> mapFile1,
                                                                             TreeMap<String, Object> mapFile2) {
        TreeMap<String, Map<String, ArrayList<Object>>> resultDiffFile1AndFile2 = new TreeMap<>();
        for (String key : sortedFile1AndFile2) {
            ArrayList<Object> value = new ArrayList<>();
            Map<String, ArrayList<Object>> diff = new HashMap<>();
            if (!mapFile1.containsKey(key)) {
                value.add(mapFile2.get(key));
                diff.put("add", value);
                resultDiffFile1AndFile2.put(key, diff);
            } else if (mapFile2.containsKey(key) && mapFile1.get(key) != null
                    && mapFile2.get(key) != null && mapFile1.get(key).equals(mapFile2.get(key))) {
                value.add(mapFile1.get(key));
                diff.put("unchanged", value);
                resultDiffFile1AndFile2.put(key, diff);
            } else if (mapFile2.containsKey(key) && mapFile1.get(key) == null
                    && mapFile2.get(key) == null) {
                value.add(mapFile1.get(key));
                diff.put("unchanged", value);
                resultDiffFile1AndFile2.put(key, diff);
            } else if (mapFile2.containsKey(key)
                    && (mapFile1.get(key) == null || mapFile2.get(key) == null)) {
                value.add(mapFile1.get(key));
                value.add(mapFile2.get(key));
                diff.put("changed", value);
                resultDiffFile1AndFile2.put(key, diff);
            } else if (mapFile2.containsKey(key) && !mapFile1.get(key).equals(mapFile2.get(key))) {
                value.add(mapFile1.get(key));
                value.add(mapFile2.get(key));
                diff.put("changed", value);
                resultDiffFile1AndFile2.put(key, diff);
            } else {
                value.add(mapFile1.get(key));
                diff.put("removed", value);
                resultDiffFile1AndFile2.put(key, diff);
            }
        }
        return resultDiffFile1AndFile2;
    }
}

