package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String data, String format) throws IOException {
        final ObjectMapper mapper = switch (format) {
            case "yml" -> new ObjectMapper(new YAMLFactory());
            case "json" -> new ObjectMapper(new JsonFactory());
            default -> throw new RuntimeException();
        };
        return mapper.readValue(data, new TypeReference<>() {
        });

    }
}
