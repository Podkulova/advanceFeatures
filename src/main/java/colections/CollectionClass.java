package colections;

import java.util.*;

public class CollectionClass {

    public static Set<String> getStrSet(){
        // sada unikatnich retezcu - nejde vlozit 2x stejny retezec
        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        set.add("ccc"); // toto se tam nedostane, ccc uz tam je
        set.add("ddd");
        return set;
        /*
        HashSet: pořadí položek není dodrženo ukládá informace do hash tabulky
        TreeSet: pořadí prvků je zachováno podle tzv. přirozeného řádu nebo podle nějakého [Comparator] (collections.md # comparator)
            ukládá data do červeno-černého stromu
        LinkedHashSet: ukládá informace o pořadí přidávání jednotlivých prvků implementace je založena na hashovací tabulce s podporou propojených seznamů
        */
    }
    public static Set<DataClass> getDataClassSet(){
        // sada unikatnich dat
        Set<DataClass> set = new HashSet<>();
        set.add(new DataClass("Karel", 25));
        set.add(new DataClass("Josef", 28));
        set.add(new DataClass("Josef", 28));
        return set;
    }

    public static List<String> getStrList(){
        List<String> list = new ArrayList<>();
        list.add("aaa-list");
        list.add("bbb-list");
        list.add("ccc-list");
        list.add("ccc-list"); // toto se dostane, nereci duplicity
        list.add("ddd-list");
        return list;
    }

    public static Queue<String> getQueueString(){
        Queue<String> queue = new LinkedList<>();
        queue.offer("1 prvni"); // u queue pouzivejte pro pridavani offer
        queue.offer("2 druhy");
        queue.offer("3 treti");
        queue.offer("4 ctvrty");

        return queue;
    }

    public static Deque<String> getDeQueueString(){
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("1 prvni");
        queue.offer("2 druhy");
        queue.offer("3 treti");
        queue.offer("4 ctvrty");
        return queue;
    }

    public static Map<String, DataClass> getMap(){

        Map<String, DataClass> map = new HashMap<>();
        map.put("jedna", new DataClass("1-Karel", 25));
        map.put("dve", new DataClass("2-Josez", 28));
        map.put("tri", new DataClass("3-Petr", 19));
        map.put("tri", new DataClass("3-Novy Petr", 19)); // stejny klic, hodnota se prepiše
        map.put("ctyri", new DataClass("4-Pavel", 19));

        map.put("pet", new DataClass("5-Jakub", 19));
        return map;
        /*
        HashMap: pořadí dvojic není zachováno ukládá informace do hash tabulky.
        TreeMap: pořadí dvojic je zachováno podle tzv. přirozeného pořadí klíčů nebo podle určitého komparátoru klíčů
                 ukládá data do červeno-černého stromu.
        LinkedHashMap: ukládá informaci o pořadí přidávání jednotlivých dvojic implementace je založena na hashovací tabulce s podporou propojených seznamů.
        * */

    }

}
