package hexlet.code;


import java.io.IOException;
import java.util.*;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        TreeMap<Object, Object> mapFilePath1 = Parser.input(filePath1);
        TreeMap<Object, Object> mapFilePath2 = Parser.input(filePath2);
        Set<Object> setKeys = mapFilePath1.keySet();
        TreeSet<Object> sortedSet = new TreeSet<>(setKeys);
        Set<Object> setKeys1 = mapFilePath2.keySet();
        sortedSet.addAll(setKeys1);
        StringBuilder result = new StringBuilder("{ \n");
        for (Object key : sortedSet) {
            if (!mapFilePath1.containsKey(key)) {
                result.append(" + ").append(key).append(": ").append(mapFilePath2.get(key)).append("\n");
            } else if (mapFilePath2.containsKey(key) && mapFilePath1.get(key) != null && mapFilePath2.get(key) != null &&
                    mapFilePath1.get(key).equals(mapFilePath2.get(key))) {
                result.append("   ").append(key).append(": ").append(mapFilePath1.get(key)).append("\n");
            } else if (mapFilePath2.containsKey(key) && mapFilePath1.get(key) != null && mapFilePath2.get(key) == null) {
                result.append(" - ").append(key).append(": ").append(mapFilePath1.get(key)).append("\n")
                        .append(" + ").append(key).append(": ").append(mapFilePath2.get(key)).append("\n");
            } else if (mapFilePath2.containsKey(key) && mapFilePath1.get(key) == null && mapFilePath2.get(key) != null) {
                result.append(" - ").append(key).append(": ").append(mapFilePath1.get(key)).append("\n")
                        .append(" + ").append(key).append(": ").append(mapFilePath2.get(key)).append("\n");
            } else if (mapFilePath2.containsKey(key) && !mapFilePath1.get(key).equals(mapFilePath2.get(key))) {
                result.append(" - ").append(key).append(": ").append(mapFilePath1.get(key)).append("\n")
                        .append(" + ").append(key).append(": ").append(mapFilePath2.get(key)).append("\n");
            } else {
                result.append(" - ").append(key).append(": ").append(mapFilePath1.get(key)).append("\n");
            }
        }
        result.append("}");

        return result.toString();
    }
}
