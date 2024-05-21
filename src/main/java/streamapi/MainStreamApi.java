package streamapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Ukazka prace se stream api
public class MainStreamApi {

    public static void main(String[] args) throws Exception {
        streamArray();
        iteraceStrem();
        streamFind();
        streamFilter();
        streamMinMax();
        streamFilterCount();
        streamReduce();
        streamApiSort();
    }


    private static List<String> createList() {
        // pomocna metoda vyrabi List
        List<String> items = new ArrayList<String>();
        items.add("one");
        items.add("two2");
        items.add("three");
        items.add("44");
        items.add("55");
        items.add("66");
        items.add("555");
        return items;
    }

    public static void streamArray() {
        // vytvoreni stream z pole int
        int[] intArray = new int[]{1, 2, 3};
        IntStream arraysStream = Arrays.stream(intArray);

        // vytvoreni stream z listu
        List<String> items = createList();
        Stream<String> stream = items.stream(); // pozadovany stream
    }


    public static void iteraceStrem() {
        // kazdy stream umi iterovat (prochazet) polozky (podobne jako kolekce)
        List<String> items = createList();
        Stream<String> stream = items.stream();
        stream.forEach(s -> System.out.println(s));
    }



    public static void streamFind() {
        // hledani ve stream
        // find
        Stream<String> stream = Stream.of("a", "b", "c");

        Optional<String> anyElement02 = stream.filter(element -> element.contains("b")).findAny();
        if(anyElement02.isPresent()){
            System.out.println("02-" + anyElement02.get());
        }
    }

    public static void streamFilter() {
        // filter
        List<Integer> list = Arrays.asList(3, 4, 6, 12, 20);
        List<Integer> filtredlist = list.stream()
                .filter(num -> num > 7)
                .collect(Collectors.toList());
        filtredlist.forEach(integer -> System.out.println(integer));
    }


    public static void streamMinMax() throws Exception{
        // min max atd
        List<String> items = new ArrayList<String>();
        items.add("XY");
        items.add("one");
        items.add("two2");
        items.add("three");

        String shortest = items.stream()
                .min(Comparator.comparing(item -> item.length()))
                .get();

        System.out.println(shortest);
    }

    public static void streamFilterCount() throws Exception{
        // count filtrujeme t
        List<String> items = new ArrayList<String>();
        items.add("one");
        items.add("two2");
        items.add("three");

        long count = items.stream()
                .filter( item -> item.startsWith("t"))
                .count();

        System.out.println(count);
    }


    public static void streamReduce() throws Exception{
        // reduce - redukuje na jeden string
        List<String> items = new ArrayList<String>();
        items.add("one");
        items.add("two2");
        items.add("three");

        String reduced2 = items.stream()
                .reduce((acc, item) -> acc + "|" + item)
                .get();

        System.out.println(reduced2);
    }


    public static void streamApiSort() throws Exception{

        System.out.println("--------------------------------");
        // serazeni od UP->DOWN
        Arrays.asList(6, 3, 6, 21, 20, 1)
                .stream()
                .sorted(Comparator.reverseOrder())
                .forEach(integer -> System.out.println(integer));
        System.out.println("--------------------------------");
        // vyrazeni duplicit
        Arrays.asList(3, 6, 6, 20, 21, 21).stream()
                .distinct()
                .forEach(integer -> System.out.println(integer));


    }
}
