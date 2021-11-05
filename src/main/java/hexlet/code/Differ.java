package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        final Map<String, Object> mapFile1 = readToMap(filePath1);
        final Map<String, Object> mapFile2 = readToMap(filePath2);
        final Set<String> sortedKeys = toSetOfKeys(mapFile1, mapFile2);
        final Map<String, Map<String, List<Object>>> diff = createDiff(sortedKeys, mapFile1, mapFile2);
        return Formatter.format(diff, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    public static Map<String, Object> readToMap(String fileName)
            throws IOException {
        final String formatFile = determineFormat(fileName);
        final Path fileForParse = Paths.get(fileName).normalize()
                .toAbsolutePath();
        final String content = Files.readString(fileForParse);
        return Parser.parse(content, formatFile);
    }

    public static Set<String> toSetOfKeys(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {
        final Set<String> setKeysFile1 = mapFile1.keySet();
        final Set<String> sortedKeys = new TreeSet<>(setKeysFile1);
        final Set<String> setKeysFile2 = mapFile2.keySet();
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
            final List<Object> value = new ArrayList<>();
            final Map<String, List<Object>> diff = new HashMap<>();
            if (!mapFile1.containsKey(key)) {
                value.add(mapFile2.get(key));
                diff.put("add", value);
                resultDiff.put(key, diff);
            }
            if (Objects.equals(mapFile1.get(key), mapFile2.get(key))) {
                value.add(mapFile1.get(key));
                diff.put("unchanged", value);
                resultDiff.put(key, diff);
            }
            if (!Objects.equals(mapFile1.get(key), mapFile2.get(key)) &&
                    (mapFile1.containsKey(key) && mapFile2.containsKey(key))) {
                value.add(mapFile1.get(key));
                value.add(mapFile2.get(key));
                diff.put("changed", value);
                resultDiff.put(key, diff);
            }
            if (!mapFile2.containsKey(key)) {
                value.add(mapFile1.get(key));
                diff.put("removed", value);
                resultDiff.put(key, diff);
            }
        }
        return resultDiff;
    }
}
