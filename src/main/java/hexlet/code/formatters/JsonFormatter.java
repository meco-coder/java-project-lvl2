package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsonFormatter {
    public static String jsonFormat(Map<String, Map<String, List<Object>>> diff)
            throws JsonProcessingException {
        final HashMap<Object, Object> resultDiff = new HashMap<>();
        final Set<String> keys = diff.keySet();
        for (String key : keys) {
            final String keyOfValue = String.join("", diff.get(key).keySet());
            resultDiff.putAll(formatDiff(keyOfValue, key, diff));
        }
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(resultDiff);
    }

    public static HashMap<Object, Object> formatDiff(String keyOfValue, String key,
                                                     Map<String, Map<String, List<Object>>> diff) {
        final HashMap<Object, Object> resultFormatDiff = new HashMap<>();
        switch (keyOfValue) {
            case "add" -> {
                resultFormatDiff.put(key, diff.get(key).get("add").get(0));
                return resultFormatDiff;
            }
            case "changed" -> {
                resultFormatDiff.put(key, diff.get(key).get("changed").get(1));
                return resultFormatDiff;
            }

            case "removed" -> {
                resultFormatDiff.put(key, diff.get(key).get("removed").get(0));
                return resultFormatDiff;
            }
            case "unchanged" -> {
                return resultFormatDiff;
            }

            default -> throw new RuntimeException();
        }
    }
}
