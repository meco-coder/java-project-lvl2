package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.TreeMap;

public class Parser {

    public final TreeMap<String, Object> parse(String data, String format) throws IOException {
        TreeMap<String, Object> mapFile;
        ObjectMapper mapper = new ObjectMapper();
        if (format.equals("yml")) {
            mapper = new ObjectMapper(new YAMLFactory());
        }
        mapFile = mapper.readValue(data, new TypeReference<>() {
        });
        return mapFile;
    }
}
