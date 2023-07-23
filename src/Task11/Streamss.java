package Task11;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streamss {
    public static void main(String[] args) {
        /*Завдання 1
        Метод приймає на вхід список імен. Необхідно повернути рядок вигляду 1. Ivan, 3. Peter... лише з тими іменами,
        що стоять під непарним індексом (1, 3 тощо)
         */
        System.out.println("Завдання 1");
        List<String> namesList = Arrays.asList("Maria", "Nikita", "Ivan", "Loki", "Felicia");
        IntStream.range(0, namesList.size())
                .filter(index -> index % 2 == 1)
                .mapToObj(index -> String.format("%d.%s, ", index, namesList.get(index)))
                .forEach(System.out::print);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println();
        System.out.println();
        /*Завдання 2
        Метод приймає на вхід список рядків (можна взяти список із Завдання 1).
        Повертає список цих рядків у верхньому регістрі, і відсортованих за спаданням (від Z до A).
         */
        System.out.println("Завдання 2");
        namesList.stream()
                .map(s -> s.toUpperCase() + " ")
                //.map(s -> s.substring(0, 1).toLowerCase() + s.substring(1))
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::print);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println();
        System.out.println();
        /*Завдання 3
        Є масив:["1, 2, 0", "4, 5"]
        Необхідно отримати з масиву всі числа, і вивести їх у відсортованому вигляді через кому ,, наприклад:
        "0, 1, 2, 4, 5"
         */
        System.out.println("Завдання 3");
        List<Integer> result =Streamss.toArray(new Integer[][]{{10, 2, 0} ,{8, 5, 1}});
        result.stream().sorted()
               .forEach(s -> System.out.print(s + ", "));
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println();
        System.out.println();
        /*Завдання 4
        Використовуючи Stream.iterate, створіть безкінечний стрім випадкових чисел, але не використовуючи Math.random().
            Реалізуйте свій лінійний конгруентний генератор. Для цього почніть з x[0] = seed, і далі кожний наступний елемент
        рахуйте за формулою на зразок x[n + 1] = 1 (a x[n] + c) % m для коректних значень a, c, та m.
            Необхідно імплементувати метод, що приймає на вхід параметри a, c, та m, і повертає Stream<Long>.
        Для тесту використовуйте такі дані:
        a = 25214903917
        c = 11
        m = 2^48 (2в степені48`)
        */
        System.out.println("Завдання 4");
        long a = 25214903917L;
        long c = 11;
        long m = (long) Math.pow(2, 48);
        LongStream stream=generator(a,c,m,10);
        stream.forEach(s -> System.out.print(s + ", "));
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println();
        System.out.println();
        /*Завдання 5
        Напишіть метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) який "перемішує"
        елементи зі стрімів first та second, зупиняючись тоді, коли у одного зі стрімів закінчаться елементи.
         */
        System.out.println("Завдання 5");
        List<String> first = Arrays.asList("1", "3", "5", "7", "9");
        List<String> second = Arrays.asList("2", "4", "6", "8");
        Stream<String> firstS=first.stream();
        Stream<String> secondS=second.stream();

        Stream<String> resultS=zip(firstS,secondS);
        resultS.forEach(System.out::print);

    }
    //Завдання 3
private static <T> List<T> toArray(T[][] array) {
    final List<T> result = new ArrayList<>();
    for (T[] arrays : array) result.addAll(Arrays.asList(arrays));
    return result;
}
//Завдання 4
    //Возвращает поток псевдослучайных, однородно распределенных long значения от последовательности этого генератора случайных чисел.
    static LongStream generator(long a, long c, long m,int limits) {
         LongStream stream=Stream.iterate(0, n -> n + 1)
                .mapToLong(n -> (a * n + c) % m)
                 .limit(limits);
        return stream;
    }
//Завдання 5
    static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> result = new ArrayList<>();
        Iterator<T> firstStream=first.iterator();
        Iterator<T> secondStream=second.iterator();
        while (firstStream.hasNext()&&secondStream.hasNext()){
            result.add(firstStream.next());
            result.add(secondStream.next());
        }
        return result.stream();
    }

}

