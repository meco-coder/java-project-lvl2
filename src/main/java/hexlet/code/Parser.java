package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.TreeMap;

public class Parser {

    public final TreeMap<String, Object> parserForFile1AndFile2(String data, String formatFile) throws IOException {
        TreeMap<String, Object> mapFile = new TreeMap<>();
        if (formatFile.equals("yml")) {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();
            mapFile = mapper.readValue(data, new TypeReference<>() {
            });
            return mapFile;
        } else if (formatFile.equals("json")) {
            ObjectMapper mapper = new ObjectMapper();
            mapFile = mapper.readValue(data, new TypeReference<>() {
            });
            return mapFile;
        }
        return mapFile;
    }
}
