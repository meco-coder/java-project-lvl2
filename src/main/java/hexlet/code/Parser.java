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

    public final TreeMap<T1, T2> parserForFile1AndFile2(String file) throws IOException {
        String fileToString = "";
        TreeMap<T1, T2> mapFile = new TreeMap<>();
        Path fileForParse = Paths.get(file).normalize();
        if (!fileForParse.isAbsolute()) {
            fileForParse = Paths.get("src", "test", "resources", "fixtures", file)
                    .toAbsolutePath()
                    .normalize();
        }
        fileToString = Files.readString(fileForParse);
        if (file.endsWith(".yml")) {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();
            mapFile = mapper.readValue(fileToString, new TypeReference<>() {
            });
            return mapFile;
        } else if (file.endsWith(".json")) {
            ObjectMapper mapper = new ObjectMapper();
            mapFile = mapper.readValue(fileToString, new TypeReference<>() {
            });
            return mapFile;
        }
        return mapFile;
    }
}
