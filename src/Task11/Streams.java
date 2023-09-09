package Task11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.*;

public class Streams {
    public static void main(String[] args) {

        List<String> namesList = Arrays.asList("Maria", "Nikita", "Ivan", "Loki", "Felicia");
        String[][] stringMas = {{"1, 2, 0"}, {"7, 6, 1"}, {"5, 3, 4"}};
        List<String> first = Arrays.asList("1", "3", "5", "7", "9");
        List<String> second = Arrays.asList("2", "4", "6", "8");
        Stream<String> firstS = first.stream();
        Stream<String> secondS = second.stream();

        System.out.println("Завдання 1");
        oddNames(namesList);
        System.out.println();
        System.out.println("Завдання 2");
        toUpperCase(namesList);
        System.out.println();
        System.out.println("Завдання 3");
        massStringSort(stringMas);
        System.out.println();
        System.out.println("Завдання 4");
        long a = 25214903917L;
        long c = 11;
        long m = (long) Math.pow(2, 48);
        Stream<Long> stream = generator(a, c, m, 10);
        stream.forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("Завдання 5");
        Stream<String> resultS = zip(firstS, secondS);
        resultS.forEach(System.out::print);
    }

    //Завдання 1
    public static void oddNames(List<String> namesList) {
        IntStream.range(0, namesList.size())
                .filter(index -> index % 2 == 1)
                .mapToObj(index -> String.format("%d.%s, ", index, namesList.get(index)))
                .forEach(System.out::print);
    }

    //Завдання 2
    public static void toUpperCase(List<String> namesList) {
        namesList.stream()
                .map(s -> s.toUpperCase() + " ")
                //.map(s -> s.substring(0, 1).toLowerCase() + s.substring(1))
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::print);
    }

    //Завдання 3
    public static void massStringSort(String[][] stringMas) {
        String listString = Stream.of(stringMas)
                .flatMap(Arrays::stream)
                .map(m -> m.replaceAll(",", ""))
                .map(m -> m.replaceAll(" ", ""))
                .collect(Collectors.joining());
        String str = Arrays.stream(listString.split(""))
                .reduce((x, y) -> x + ' ' + y)
                .get();
        Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .sorted()
                .forEach(s -> System.out.print(s + ","));
    }

    //Завдання 4

    static Stream<Long> generator(long a, long c, long m, int limits) {
        Stream<Long> result = Stream.iterate(0, n -> n + 1)
                .map(n -> (a * n + c) % m)
                .limit(limits);
        return result;
    }

    //Завдання 5
    static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> result = new ArrayList<>();
        Iterator<T> firstStream = first.iterator();
        Iterator<T> secondStream = second.iterator();
        while (firstStream.hasNext() && secondStream.hasNext()) {
            result.add(firstStream.next());
            result.add(secondStream.next());
        }
        return result.stream();
    }

}
