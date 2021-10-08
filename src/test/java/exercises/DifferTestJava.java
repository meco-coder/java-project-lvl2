package exercises;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import hexlet.code.App;
//import hexlet.code.Differ;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Scanner;
//
//public class DifferTestJava {
//    private static String data1;
//    private static String data2;
//    private static String data3;
//    private static String expected;
//
//    private static Path getFixturePath(String fileName) {
//        return Paths.get("src", "test", "resources", "fixtures", fileName)
//                .toAbsolutePath().normalize();
//    }
//
//    private static String readFixture(String fileName) throws Exception {
//        Path filePath = getFixturePath(fileName);
//        return Files.readString(filePath).trim();
//    }
//
//    @BeforeAll
//    public static void beforeAll() throws Exception {
//        data1 = readFixture("file1.json");
//        data2 = readFixture("file2.json");
//        data3 = readFixture("file4.json");
//        expected = readFixture("file3.txt");
//    }
//
//    @Test
//    void testGetDiffer1() throws IOException {
//        String resultDiffer = Differ.generate(data1, data2,"stylish");
//        Assertions.assertEquals(expected, resultDiffer);
//    }
//}


//    @Test
//    void testGetDiffer2() {
//        try {
//            return Differ.generate(data1, data2);
//
//        }
//        } catch(JsonProcessingException e)
//
//    {
//    }
//
//            e.printStackTrace();
//
//
//        }
//    }
//}
