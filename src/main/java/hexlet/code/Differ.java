package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        Set<String> sortedKeys = toSetOfKeys(parse(filePath1, determineFormat(filePath1)),
                parse(filePath2, determineFormat(filePath2)));
        Map<String, Map<String, List<Object>>> diff = createDiff(sortedKeys,
                parse(filePath1, determineFormat(filePath1)), parse(filePath2, determineFormat(filePath2)));
        return Formatter.format(diff, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    public static Map<String, Object> parse(String fileName, String formatFile)
            throws IOException {
        final String dataToString;
        Path fileForParse = Paths.get(fileName).normalize()
                .toAbsolutePath();
        dataToString = Files.readString(fileForParse);
        return Parser.parse(dataToString, formatFile);
    }

    public static Set<String> toSetOfKeys(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {
        Set<String> setKeysFile1 = mapFile1.keySet();
        Set<String> sortedKeys = new TreeSet<>(setKeysFile1);
        Set<String> setKeysFile2 = mapFile2.keySet();
        sortedKeys.addAll(setKeysFile2);
        return sortedKeys;
    }

    public static String determineFormat(String fileName) {
        String formatFile = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            formatFile = fileName.substring(i + 1);
        }
        return formatFile;
    }

    public static Map<String, Map<String, List<Object>>> createDiff(Set<String> sortedFile1AndFile2,
                                                                    Map<String, Object> mapFile1,
                                                                    Map<String, Object> mapFile2) {
        final Map<String, Map<String, List<Object>>> resultDiff = new TreeMap<>();
        for (String key : sortedFile1AndFile2) {
            List<Object> value = new ArrayList<>();
            Map<String, List<Object>> diff = new HashMap<>();
            if (!mapFile1.containsKey(key)) {
                value.add(mapFile2.get(key));
                diff.put("add", value);
                resultDiff.put(key, diff);
            } else if (mapFile2.containsKey(key) && mapFile1.get(key) != null
                    && mapFile2.get(key) != null && mapFile1.get(key).equals(mapFile2.get(key))) {
                value.add(mapFile1.get(key));
                diff.put("unchanged", value);
                resultDiff.put(key, diff);
            } else if (mapFile2.containsKey(key) && mapFile1.get(key) == null
                    && mapFile2.get(key) == null) {
                value.add(mapFile1.get(key));
                diff.put("unchanged", value);
                resultDiff.put(key, diff);
            } else if (mapFile2.containsKey(key)
                    && (mapFile1.get(key) == null || mapFile2.get(key) == null)) {
                value.add(mapFile1.get(key));
                value.add(mapFile2.get(key));
                diff.put("changed", value);
                resultDiff.put(key, diff);
            } else if (mapFile2.containsKey(key) && !mapFile1.get(key).equals(mapFile2.get(key))) {
                value.add(mapFile1.get(key));
                value.add(mapFile2.get(key));
                diff.put("changed", value);
                resultDiff.put(key, diff);
            } else {
                value.add(mapFile1.get(key));
                diff.put("removed", value);
                resultDiff.put(key, diff);
            }
        }
        return resultDiff;
    }
}

