package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Parser {
    private static TreeMap<Object, Object> mapFilePath;

    public static TreeMap<Object, Object> input(String file) throws IOException {
        Path filePath = Paths.get("src", "test", "resources", "fixtures", file).toAbsolutePath()
                .normalize();
        String fileString = Files.readString(filePath).trim();
        if (file.endsWith(".yaml")) {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();
            mapFilePath = mapper.readValue(fileString, new TypeReference<>() {
            });
            return mapFilePath;
        } else if (file.endsWith(".json")) {
            ObjectMapper mapper = new ObjectMapper();
            mapFilePath = mapper.readValue(fileString, new TypeReference<>() {
            });
            return mapFilePath;
        }
        return mapFilePath;
    }
}
