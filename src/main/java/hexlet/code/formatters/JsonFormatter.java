package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JsonFormatter {
    public static String jsonFormat(Map<String, Map<String, ArrayList<Object>>> resultDifferFile1AndFile2)
            throws JsonProcessingException {
        String resultToString = "";
        HashMap<Object, Object> result = new HashMap<>();
        Set<String> result1 = resultDifferFile1AndFile2.keySet();
        for (String key : result1) {
            if (resultDifferFile1AndFile2.get(key).containsKey("add")) {
                result.put(key, resultDifferFile1AndFile2.get(key).get("add").get(0));
            } else if (resultDifferFile1AndFile2.get(key).containsKey("changed")) {
                result.put(key, resultDifferFile1AndFile2.get(key).get("changed").get(1));
            } else if (resultDifferFile1AndFile2.get(key).containsKey("removed")) {
                result.put(key, resultDifferFile1AndFile2.get(key).get("removed").get(0));
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        resultToString = objectMapper.writeValueAsString(result);
        return resultToString;
    }
}
