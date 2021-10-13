package hexlet.code;

import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {
    private static TreeMap<Object, Object> mapFilePath1 = new TreeMap<>();
    private static TreeMap<Object, Object> mapFilePath2 = new TreeMap<>();

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        TreeSet<Object> sortedFilePath1AndFilePath2 = parserKey(filePath1, filePath2);
        for (Object key : sortedFilePath1AndFilePath2) {
            if (!mapFilePath1.containsKey(key)) {
                Formatter.add(key, mapFilePath2.get(key), format);
            } else if (mapFilePath2.containsKey(key) && mapFilePath1.get(key) != null
                    && mapFilePath2.get(key) != null && mapFilePath1.get(key).equals(mapFilePath2.get(key))) {
                Formatter.unchanged(key, mapFilePath1.get(key), format);
            } else if (mapFilePath2.containsKey(key) && mapFilePath1.get(key) == null
                    && mapFilePath2.get(key) == null) {
                Formatter.unchanged(key, mapFilePath1.get(key), format);
            } else if (mapFilePath2.containsKey(key)
                    && (mapFilePath1.get(key) == null || mapFilePath2.get(key) == null)) {
                Formatter.changed(key, mapFilePath1.get(key), mapFilePath2.get(key), format);
            } else if (mapFilePath2.containsKey(key) && !mapFilePath1.get(key).equals(mapFilePath2.get(key))) {
                Formatter.changed(key, mapFilePath1.get(key), mapFilePath2.get(key), format);
            } else {
                Formatter.remove(key, mapFilePath1.get(key), format);
            }
        }
        return Formatter.getResult(format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    public static TreeSet<Object> parserKey(String filePath1, String filePath2) throws IOException {
        Parser<Object, Object> parser = new Parser<>();
        mapFilePath1 = parser.input(filePath1);
        mapFilePath2 = parser.input(filePath2);
        Set<Object> setKeysFilePath1 = mapFilePath1.keySet();
        Set<Object> setKeysFilePath2 = mapFilePath2.keySet();
        TreeSet<Object> sortedFilePath1AndFilePath2 = new TreeSet<>(setKeysFilePath1);
        sortedFilePath1AndFilePath2.addAll(setKeysFilePath2);
        return sortedFilePath1AndFilePath2;
    }
}
