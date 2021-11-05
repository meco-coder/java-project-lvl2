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
            switch (keyOfValue) {
                case "add":
                    resultDiff.put(key, diff.get(key).get("add").get(0));
                    break;
                case "changed":
                    resultDiff.put(key, diff.get(key).get("changed").get(1));
                    break;
                case "removed":
                    resultDiff.put(key, diff.get(key).get("removed").get(0));
                    break;
                case "unchanged":
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        final ObjectMapper objectMapper = new ObjectMapper();
        final String diffAsJson;
        diffAsJson = objectMapper.writeValueAsString(resultDiff);
        return diffAsJson;
    }
}
