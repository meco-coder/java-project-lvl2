package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class JsonFormatter {
    private static String rr;
    private static HashMap<Object,Object> result = new HashMap<>();

    public static void differJson(Object key, Object value) throws JsonProcessingException {
        result.put(key,value);
        ObjectMapper objectMapper = new ObjectMapper();
        rr = objectMapper.writeValueAsString(result);
    }
    public static String getResult() {
        return rr;
    }
}
