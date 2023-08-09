package Task10;

import java.io.*;
import java.util.*;

public class WordCounting {
    public static void main(String[] args) throws IOException {
        String content = "the day is  sunny the the\n the sunny is is";
        File base = new File("./src/Task10/SourceFiles");
        File source3 = new File(base, "SourceForTask3.txt");
        Map<String, Integer> list = new TreeMap<>();

        fillContents(source3, content);
        quantity(source3, list);
    }

    static void fillContents(File file, String content) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

        static void quantity(File source3, Map<String, Integer> list) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(source3)) {
            String word;
            while (scanner.hasNextLine()) {
                word = scanner.next();
                list.put(word, list.getOrDefault(word, 0) + 1);
            }
        }
        list.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }


}
