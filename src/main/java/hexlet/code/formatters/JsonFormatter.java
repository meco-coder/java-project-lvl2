package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JsonFormatter {
    public static String jsonFormat(Map<String, Map<String, ArrayList<Object>>> diff)
            throws JsonProcessingException {
        String resultToString = "";
        HashMap<Object, Object> resultDiff = new HashMap<>();
        Set<String> keys = diff.keySet();
        for (String key : keys) {
            if (diff.get(key).containsKey("add")) {
                resultDiff.put(key, diff.get(key).get("add").get(0));
            } else if (diff.get(key).containsKey("changed")) {
                resultDiff.put(key, diff.get(key).get("changed").get(1));
            } else if (diff.get(key).containsKey("removed")) {
                resultDiff.put(key, diff.get(key).get("removed").get(0));
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        resultToString = objectMapper.writeValueAsString(resultDiff);
        return resultToString;
    }
}
