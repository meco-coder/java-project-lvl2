package hexlet.code;

import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {
    private static TreeMap<Object, Object> mapFile1 = new TreeMap<>();
    private static TreeMap<Object, Object> mapFile2 = new TreeMap<>();

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        TreeSet<Object> sortedFilePath1AndFilePath2 = parserKey(filePath1, filePath2);
        for (Object key : sortedFilePath1AndFilePath2) {
            if (!mapFile1.containsKey(key)) {
                Formatter.add(key, mapFile2.get(key), format);
            } else if (mapFile2.containsKey(key) && mapFile1.get(key) != null
                    && mapFile2.get(key) != null && mapFile1.get(key).equals(mapFile2.get(key))) {
                Formatter.unchanged(key, mapFile1.get(key), format);
            } else if (mapFile2.containsKey(key) && mapFile1.get(key) == null
                    && mapFile2.get(key) == null) {
                Formatter.unchanged(key, mapFile1.get(key), format);
            } else if (mapFile2.containsKey(key)
                    && (mapFile1.get(key) == null || mapFile2.get(key) == null)) {
                Formatter.changed(key, mapFile1.get(key), mapFile2.get(key), format);
            } else if (mapFile2.containsKey(key) && !mapFile1.get(key).equals(mapFile2.get(key))) {
                Formatter.changed(key, mapFile1.get(key), mapFile2.get(key), format);
            } else {
                Formatter.remove(key, mapFile1.get(key), format);
            }
        }
        return Formatter.getResult(format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    public static TreeSet<Object> parserKey(String filePath1, String filePath2) throws IOException {
        Parser<Object, Object> parser = new Parser<>();
        mapFile1 = parser.parserForFile1AndFile2(filePath1);
        mapFile2 = parser.parserForFile1AndFile2(filePath2);
        Set<Object> setKeysFilePath1 = mapFile1.keySet();
        Set<Object> setKeysFilePath2 = mapFile2.keySet();
        TreeSet<Object> sortedFilePath1AndFilePath2 = new TreeSet<>(setKeysFilePath1);
        sortedFilePath1AndFilePath2.addAll(setKeysFilePath2);
        return sortedFilePath1AndFilePath2;
    }
}
