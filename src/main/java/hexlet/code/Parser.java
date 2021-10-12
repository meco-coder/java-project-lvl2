package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Parser<T1, T2> {

    public final TreeMap<T1, T2> input(String file) throws IOException {
        TreeMap<T1, T2> mapFilePath = new TreeMap<>();
        Path filePath = Paths.get(file).toAbsolutePath().normalize();
        String fileString = Files.readString(filePath);
        if (file.endsWith(".ymm")) {
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
