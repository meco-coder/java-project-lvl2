package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Differ {
    private static TreeMap<Object, Object> mapFilePath1;
    private static TreeMap<Object, Object> mapFilePath2;

    public static String generate(String filePath1, String filePath2) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapFilePath1 = mapper.readValue(filePath1, new TypeReference<>() {
        });
        mapFilePath2 = mapper.readValue(filePath2, new TypeReference<>() {
        });
        StringBuilder result = new StringBuilder("{ \n");
        Set<Map.Entry<Object, Object>> setFilePath1 = mapFilePath1.entrySet();
        Set<Map.Entry<Object, Object>> setFilePath2 = mapFilePath2.entrySet();
        for (Map.Entry<Object, Object> mapFile1 : setFilePath1) {
            Object key = mapFile1.getKey();
            Object value = mapFile1.getValue();
            if (mapFilePath2.containsKey(key) && mapFilePath2.containsValue(value)) {
                result.append("   ").append(key).append(": ").append(value).append("\n");
            } else if (mapFilePath2.containsKey(key) && !mapFilePath2.containsValue(value)) {
                result.append(" - ").append(key).append(": ").append(value).append("\n")
                        .append(" + ").append(key).append(": ").append(mapFilePath2.get(key)).append("\n");
            } else {
                result.append(" - ").append(key).append(": ").append(value).append("\n");
            }
        }

        for (Map.Entry<Object, Object> mapFile1 : setFilePath2) {
            Object key = mapFile1.getKey();
            Object value = mapFile1.getValue();
            if (!mapFilePath1.containsKey(key)) {
                result.append(" + ").append(key).append(": ").append(value).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
