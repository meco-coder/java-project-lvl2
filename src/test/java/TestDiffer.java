import hexlet.code.Differ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDiffer {
    private static String fileString1;
    private static String fileString2;
    private static String fileString3;
    private static String fileString4;
    private static String fileString5;
    private static String fileString6;
    private static String fileString7;
    private static String fileString8;
    private static String fileString9;

    @BeforeAll
    public static void inputTest() throws IOException {
        Path filePath1 = Paths.get("src", "test", "resources", "fixtures", "file1test.txt").toAbsolutePath()
                .normalize();
        fileString1 = Files.readString(filePath1).trim();
        Path filePath2 = Paths.get("src", "test", "resources", "fixtures", "file2test.txt").toAbsolutePath()
                .normalize();
        fileString2 = Files.readString(filePath2).trim();
        Path filePath3 = Paths.get("src", "test", "resources", "fixtures", "file3test.txt").toAbsolutePath()
                .normalize();
        fileString3 = Files.readString(filePath3).trim();

        Path filePath4 = Paths.get("src", "test", "resources", "fixtures", "file4test.txt").toAbsolutePath()
                .normalize();
        fileString4 = Files.readString(filePath4).trim();
        Path filePath5 = Paths.get("src", "test", "resources", "fixtures", "file5test.txt").toAbsolutePath()
                .normalize();
        fileString5 = Files.readString(filePath5).trim();
        Path filePath6 = Paths.get("src", "test", "resources", "fixtures", "file6test.txt").toAbsolutePath()
                .normalize();
        fileString6 = Files.readString(filePath6).trim();
        Path filePath7 = Paths.get("src", "test", "resources", "fixtures", "file7test.txt").toAbsolutePath()
                .normalize();
        fileString7 = Files.readString(filePath7).trim();
        Path filePath8 = Paths.get("src", "test", "resources", "fixtures", "file8test.txt").toAbsolutePath()
                .normalize();
        fileString8 = Files.readString(filePath8).trim();
        Path filePath9 = Paths.get("src", "test", "resources", "fixtures", "file9test.txt").toAbsolutePath()
                .normalize();
        fileString9 = Files.readString(filePath9).trim();

    }

    @Test
    public void differTest1() throws IOException {
        Assertions.assertEquals(fileString1, Differ.generate("file1.json", "file2.json"));
        Assertions.assertEquals(fileString2, Differ.generate("file1test.json", "file2test.json"));
        Assertions.assertEquals(fileString3, Differ.generate("file3test.json", "file4test.json"));
    }

    @Test
    public void differTest2() throws IOException {
        Assertions.assertEquals(fileString1, Differ.generate("file1.yml", "file2.yml"));
        Assertions.assertEquals(fileString2, Differ.generate("file1test.yml", "file2test.yml"));
        Assertions.assertEquals(fileString3, Differ.generate("file3test.yml", "file4test.yml"));
    }

    @Test
    public void differTest3() throws IOException {
        Assertions.assertEquals(fileString4, Differ.generate("file1.json", "file2.json", "plain"));
        Assertions.assertEquals(fileString5, Differ.generate("file1test.json", "file2test.json", "plain"));
        Assertions.assertEquals(fileString6, Differ.generate("file3test.json", "file4test.json", "plain"));
    }

    @Test
    public void differTest4() throws IOException {
        Assertions.assertEquals(fileString4, Differ.generate("file1.yml", "file2.yml", "plain"));
        Assertions.assertEquals(fileString5, Differ.generate("file1test.yml", "file2test.yml", "plain"));
        Assertions.assertEquals(fileString6, Differ.generate("file3test.yml", "file4test.yml", "plain"));
    }
    @Test
    public void differTest5() throws IOException {
        Assertions.assertEquals(fileString7, Differ.generate("file1.json", "file2.json", "json"));
        Assertions.assertEquals(fileString8, Differ.generate("file1test.json", "file2test.json", "json"));
        Assertions.assertEquals(fileString9, Differ.generate("file3test.json", "file4test.json", "json"));
    }

    @Test
    public void differTest6() throws IOException {
        Assertions.assertEquals(fileString7, Differ.generate("file1.yml", "file2.yml", "json"));
        Assertions.assertEquals(fileString8, Differ.generate("file1test.yml", "file2test.yml", "json"));
        Assertions.assertEquals(fileString9, Differ.generate("file3test.yml", "file4test.yml", "json"));
    }

}
