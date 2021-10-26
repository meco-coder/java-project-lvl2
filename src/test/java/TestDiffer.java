import hexlet.code.Differ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDiffer {

    public static String resultDiffToString(String file) throws IOException {
        Path filePath = Paths.get("src", "test", "resources", "fixtures", file)
                .toAbsolutePath()
                .normalize();
        return Files.readString(filePath).trim();
    }


    @Test
    public void differTestJson() throws IOException {
        Assertions.assertEquals(resultDiffToString("result_file1_file2_stylish.txt"), Differ.generate("file1.json", "file2.json"));
        Assertions.assertEquals(resultDiffToString("result_file1_file2_stylish.txt"), Differ.generate("file1.json", "file2.json", "stylish"));
        Assertions.assertEquals(resultDiffToString("result_file1_file2_plain.txt"), Differ.generate("file1.json", "file2.json", "plain"));
        Assertions.assertEquals(resultDiffToString("result_file1_file2_json.txt"), Differ.generate("file1.json", "file2.json", "json"));
        Assertions.assertEquals(resultDiffToString("result_file3_file4_stylish.txt"), Differ.generate("file3.json", "file4.json"));
        Assertions.assertEquals(resultDiffToString("result_file3_file4_stylish.txt"), Differ.generate("file3.json", "file4.json", "stylish"));
        Assertions.assertEquals(resultDiffToString("result_file3_file4_plain.txt"), Differ.generate("file3.json", "file4.json", "plain"));
        Assertions.assertEquals(resultDiffToString("result_file3_file4_json.txt"), Differ.generate("file3.json", "file4.json", "json"));
        Assertions.assertEquals(resultDiffToString("result_file5_file6_stylish.txt"), Differ.generate("file5.json", "file6.json"));
        Assertions.assertEquals(resultDiffToString("result_file5_file6_stylish.txt"), Differ.generate("file5.json", "file6.json", "stylish"));
        Assertions.assertEquals(resultDiffToString("result_file5_file6_plain.txt"), Differ.generate("file5.json", "file6.json", "plain"));
        Assertions.assertEquals(resultDiffToString("result_file5_file6_json.txt"), Differ.generate("file5.json", "file6.json", "json"));
    }

    @Test
    public void differTestYml() throws IOException {
        Assertions.assertEquals(resultDiffToString("result_file1_file2_stylish.txt"), Differ.generate("file1.yml", "file2.yml"));
        Assertions.assertEquals(resultDiffToString("result_file1_file2_stylish.txt"), Differ.generate("file1.yml", "file2.yml", "stylish"));
        Assertions.assertEquals(resultDiffToString("result_file1_file2_plain.txt"), Differ.generate("file1.yml", "file2.yml", "plain"));
        Assertions.assertEquals(resultDiffToString("result_file1_file2_json.txt"), Differ.generate("file1.yml", "file2.yml", "json"));
        Assertions.assertEquals(resultDiffToString("result_file3_file4_stylish.txt"), Differ.generate("file3.yml", "file4.yml"));
        Assertions.assertEquals(resultDiffToString("result_file3_file4_stylish.txt"), Differ.generate("file3.yml", "file4.yml", "stylish"));
        Assertions.assertEquals(resultDiffToString("result_file3_file4_plain.txt"), Differ.generate("file3.yml", "file4.yml", "plain"));
        Assertions.assertEquals(resultDiffToString("result_file3_file4_json.txt"), Differ.generate("file3.yml", "file4.yml", "json"));
        Assertions.assertEquals(resultDiffToString("result_file5_file6_stylish.txt"), Differ.generate("file5.yml", "file6.yml"));
        Assertions.assertEquals(resultDiffToString("result_file5_file6_stylish.txt"), Differ.generate("file5.yml", "file6.yml", "stylish"));
        Assertions.assertEquals(resultDiffToString("result_file5_file6_plain.txt"), Differ.generate("file5.yml", "file6.yml", "plain"));
        Assertions.assertEquals(resultDiffToString("result_file5_file6_json.txt"), Differ.generate("file5.yml", "file6.yml", "json"));
    }
}
