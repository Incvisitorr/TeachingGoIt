package Task10;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PhoneNumberSearch {
    public static void main(String[] args) {
        String content = "987-123-4567,9847-123-4567, DFSDGF, SDGADSRHGFA, 3466-346, 333-444-8796, 123 456 7890, 333 444 8796, (123) 456-7890, (888) 999-1111, 2131615118,\n" +
                "999-55-45, DFSD5473GF, SDGADSklo'RHGFA, 3466--346, 555 666 7777, 531 456 7832, 333-444-8796, (123) 456-7890, (888) 999-1111, 2131615118";
        File base = new File("./src/Task10/SourceFiles");
        File source = new File(base, "SourceForTask1.txt");

        List<String> result = new ArrayList<>();
        String descr1 = "(\\d{3})\\-(\\d{3})\\-(\\d{4})";
        String descr2 = "[(](\\d{3})[)][\\s](\\d{3})\\-(\\d{4})";

        fillContents(source, content);
        searchContent(source, descr1, descr2, result);
    }

    static void fillContents(File file, String content) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    static void searchContent(File source, String descr1, String descr2, List<String> result) {

        try (Scanner scanner = new Scanner(source)) {
            String line;
            Pattern pattern1 = Pattern.compile(descr1);
            Pattern pattern2 = Pattern.compile(descr2);
            MatchResult res;
            while (scanner.hasNextLine()) {
                while ((scanner.findInLine(pattern1) != null) || (scanner.findInLine(pattern2) != null)) {
                    res = scanner.match();
                    line = res.group();
                    //result.add(line);
                    System.out.println(line);
                }
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
