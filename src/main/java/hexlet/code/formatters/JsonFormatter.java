package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class JsonFormatter {
    private static String resultToString;
    private static HashMap<Object, Object> result = new HashMap<>();

    public static void differJson(Object key, Object value) throws JsonProcessingException {
        result.put(key, value);
        ObjectMapper objectMapper = new ObjectMapper();
        resultToString = objectMapper.writeValueAsString(result);
    }

    public static String getResult() {
        result = new HashMap<>();
        return resultToString;
    }
}
