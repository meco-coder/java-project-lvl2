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
    private static TreeMap<String, Object> mapFile1 = new TreeMap<>();
    private static TreeMap<String, Object> mapFile2 = new TreeMap<>();
    private static String formatFile;

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        String dataFromFile1 = readFile(filePath1);
        String dataFromFile2 = readFile(filePath2);
        TreeSet<String> sortedFilePath1AndFilePath2 = parserKey(dataFromFile1, dataFromFile2);
        TreeMap<String, Map<String, ArrayList<Object>>> resultDifferFile1AndFile2 = new TreeMap<>();
        for (String key : sortedFilePath1AndFilePath2) {
            ArrayList<Object> value = new ArrayList<>();
            Map<String, ArrayList<Object>> resultDiffer = new HashMap<>();
            if (!mapFile1.containsKey(key)) {
                value.add(mapFile2.get(key));
                resultDiffer.put("add", value);
                resultDifferFile1AndFile2.put(key, resultDiffer);
            } else if (mapFile2.containsKey(key) && mapFile1.get(key) != null
                    && mapFile2.get(key) != null && mapFile1.get(key).equals(mapFile2.get(key))) {
                value.add(mapFile1.get(key));
                resultDiffer.put("unchanged", value);
                resultDifferFile1AndFile2.put(key, resultDiffer);
            } else if (mapFile2.containsKey(key) && mapFile1.get(key) == null
                    && mapFile2.get(key) == null) {
                value.add(mapFile1.get(key));
                resultDiffer.put("unchanged", value);
                resultDifferFile1AndFile2.put(key, resultDiffer);
            } else if (mapFile2.containsKey(key)
                    && (mapFile1.get(key) == null || mapFile2.get(key) == null)) {
                value.add(mapFile1.get(key));
                value.add(mapFile2.get(key));
                resultDiffer.put("changed", value);
                resultDifferFile1AndFile2.put(key, resultDiffer);
            } else if (mapFile2.containsKey(key) && !mapFile1.get(key).equals(mapFile2.get(key))) {
                value.add(mapFile1.get(key));
                value.add(mapFile2.get(key));
                resultDiffer.put("changed", value);
                resultDifferFile1AndFile2.put(key, resultDiffer);
            } else {
                value.add(mapFile1.get(key));
                resultDiffer.put("removed", value);
                resultDifferFile1AndFile2.put(key, resultDiffer);
            }
        }
        return Formatter.format(resultDifferFile1AndFile2, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String readFile(String file) throws IOException {
        String dataToString = "";
        if (file.endsWith(".json")) {
            formatFile = "json";
        } else {
            formatFile = "yml";
        }
        Path fileForParse = Paths.get(file).normalize();
        if (!fileForParse.isAbsolute()) {
            fileForParse = Paths.get("src", "test", "resources", "fixtures", file)
                    .toAbsolutePath()
                    .normalize();
        }
        dataToString = Files.readString(fileForParse);
        return dataToString;
    }


    public static TreeSet<String> parserKey(String dataFromFile1, String dataFromFile2) throws IOException {
        Parser parser = new Parser();
        mapFile1 = parser.parserForFile1AndFile2(dataFromFile1, formatFile);
        mapFile2 = parser.parserForFile1AndFile2(dataFromFile2, formatFile);
        Set<String> setKeysFilePath1 = mapFile1.keySet();
        Set<String> setKeysFilePath2 = mapFile2.keySet();
        TreeSet<String> sortedFilePath1AndFilePath2 = new TreeSet<>(setKeysFilePath1);
        sortedFilePath1AndFilePath2.addAll(setKeysFilePath2);
        return sortedFilePath1AndFilePath2;
    }
}
