package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String data, String format) throws IOException {
        final ObjectMapper mapper;
        switch (format) {
            case "yml":
                mapper = new ObjectMapper(new YAMLFactory());
                break;
            case "json":
                mapper = new ObjectMapper(new JsonFactory());
                break;
            default:
                throw new RuntimeException();
        }
        return mapper.readValue(data, new TypeReference<>() {
        });

    }
}
