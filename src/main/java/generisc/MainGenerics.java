package generisc;

import colections.DataClass;
import interfaces.Child;
import interfaces.HumanInteface;
import interfaces.OldMan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Generika
public class MainGenerics {

    public static void main(String[] args) {
        noGeneric();
        genericInCollections();
        customGeneric();
        testTypickePouziti();
        testConstructor();
        pairTest();
        pairChilds();
        genericMethod();
        genLimits();
        genLimits02();


    }

    // negenerika ---------------------------------------------------------------------
    public static void noGeneric(){
        // vytvarime instanci Box, nastavujeme mu item ktery muze byt libovolneho typu

        Box box = new Box();
        box.setItem("polozka v boxu");

        Box box2 = new Box();
        box2.setItem(11);

        noGenProcBox(box, box2);
    }
    // predavame Box, ten ma item a nevíme jakého je datového typu
    public static void noGenProcBox(Box b, Box b2){
        Object o1 = b.getItem(); // o = neznamy typ
        Object o2 = b2.getItem(); // o = neznamy typ
    }

    // generika ---------------------------------------------------------------------
    // příklad pouzití generik v collection
    public static void genericInCollections(){

        // pouzivame u kolekci
        List<Integer> intList = new ArrayList<>();
        intList.add(11);
        Integer i = intList.get(0);

        List<String> strList = new ArrayList<>();
        //strList.add(11); // nejde
        strList.add("retezec");
        String s = strList.get(0);

        List<DataClass> dcList = new ArrayList<>();
        //strList.add(11); // nejde
        dcList.add(new DataClass("name", 44));
        DataClass dc = dcList.get(0);

        // tento list pracuje s rozhranim ManInteface
        // lze do nej vkladat i tridy ktere ho implementuji

        HumanInteface ma = new OldMan("TO SU JA ");

        List<HumanInteface> manIntList = new ArrayList<>();
        manIntList.add(new OldMan());
        manIntList.add(ma);
        manIntList.add(new Child());

        for (HumanInteface mi : manIntList) {
            mi.printName();
        }
    }

    // vlastni generika ---------------------------------------------------------------------

    public static void customGeneric() {

        // vlastni genericka trida - kde pri zadání typu definujeme
        // s jakým datovým typem s bude pracovat. zde to je String - definuje se : GenBox<String>
        GenBox<String> stringBox = new GenBox<>();
        stringBox.setItem("string here");
        // stringBox.setItem(11); // spatny typ
        genericProcBox(stringBox);

        GenBox<Integer> intBox = new GenBox<>();
        intBox.setItem(11);
        // genericProcBox(intBox); // to nejde

        // pracujeme s tridou DataClass
        GenBox<DataClass> dataCBox = new GenBox<>();
        dataCBox.setItem(new DataClass("name", 22));

        // konstruktor
        GenBox<String> strBoxWithFoctructor = new GenBox<>("initialvalue");

    }

    // zpracuje pouze generickou tridu ktera pracuje s typem String
    public static void genericProcBox(GenBox<String> b){

        String strInBox = b.getItem(); //  typ retezec
    }

    /*
    // nelze pretizit
    public static void genericProcBox(GenBox<Integer> b){

        Integer strInBox = b.getItem(); //  typ retezec
    }*/

    public static void genericProcBox(Integer iii){

        Integer intInBox = iii; //  typ retezec
    }


    public static void testTypickePouziti(){

        // pracujeme s rozhranim a vkladame tridu Child ktera ho implementuje
        // asi nejlepsi pouziti

        GenBox<HumanInteface> manBox = new GenBox<>(); // deklarace s rozhranim
        manBox.setItem(new Child()); // vstupuje potomek HumanInteface

        GenBox<HumanInteface> manBox02 = new GenBox<>(); // deklarace s rozhranim
        manBox02.setItem(new OldMan()); // vstupuje potomek HumanInteface

        genericProcInterfaceBox(manBox);
        genericProcInterfaceBox(manBox02);

    }

    public static void genericProcInterfaceBox(GenBox<HumanInteface> genBox){

        HumanInteface manInt = genBox.getItem();
        manInt.printName();

    }

    public static void testConstructor() {

        // genericka trida ktere v konstruktoru predavame data
        HumanInteface man = new OldMan();
        GenCup<HumanInteface> cup = new GenCup<>(man);

        GenCup<HumanInteface> cup02 = new GenCup<>(new Child());

        GenCup<Integer> cup03 = new GenCup<>(11);

    }

    public static void pairTest(){

        // vytvoreni genericke tridy klic/hodnota s typy Integer/DataClass
        Pair<Integer, DataClass> pair = new Pair<>();
        pair.setKey(1); // nastaveni klice
        pair.setValue(new DataClass("first", 11)); // nastaveni hodnoty
        Integer key01 = pair.getKey(); // precteni klice
        DataClass dataClass01 = pair.getValue(); // precteni hodnoty
        System.out.println("klic=" + key01 + " - hodnota=" + dataClass01);

        // stejne je konstruovana mapa (do mapy se dá přidávat více záznamů - je to kolekce)
        Map<Integer, DataClass> map = new HashMap<>();

    }

    public static void pairChilds(){

        // Potomek muze pracovat klicem definovanym zde jako <String>
        // hodnota byla definovana jako Integer pri dedeni v tride PairChild01
        PairChild01<String> child01 = new PairChild01<>();
        child01.setKey("some string11");
        child01.setValue(555);

        // potomek muze pracovat jen s <Integer, String>
        // to bylo deklarovano v tride PairChild02 ( extends Pair<Integer, String> )
        PairChild02 pchild = new PairChild02();
        pchild.setKey(11);
        pchild.setValue("stingX");

    }


    public static void genericMethod(){

        // generická metoda převezme jen takové typy parametrů, jaké jsou deklarovány
        // v promenné ( Pair<Integer, String> firstPair ) tedy Integer + String
        Pair<Integer, String> firstPair = GeneriMethod.generatePair(1, "abcd");
        Pair<Integer, DataClass> nextPair = GeneriMethod.generatePair(1, new DataClass("name", 11));

        String str = GeneriMethod.getString("teststr");
        System.out.println(str);

        String s2 = GeneriMethod.getString(111);
        System.out.println(s2);

    }

    public static void genLimits(){

        // genericka trida NumericBox definuje generiku jako <T extends Number>
        // proto jdou pouzit jen typy zdedene z Number

        // Integer jde pouzit, dedi z Number
        NumericBox<Integer> numBox = new NumericBox<>();
        numBox.setItem(11);
        // Double jde pouzit, dedi z Number
        NumericBox<Double> numDabBox = new NumericBox<>();
        numDabBox.setItem(11.1);

        /*
        // nejde pouzit String - nededi z Number
        NumericBox<String> numStrBox = new NumericBox<>();
        numStrBox.setItem("");
        */
    }

    public static void genLimits02(){
        List<Integer> intlist = new ArrayList<>();
        intlist.add(55);
        intlist.add(100);

        double doe = GenercisLimits.sum(intlist);
        System.out.println(doe);

        // nelze pouzit metoda pracuje pouze List<Number> a na potomcich
        //List<String> strlist = new ArrayList<>();
        //GenercisLimits.sum(strlist);


        List<Integer> intlist02 = new ArrayList<>();
        intlist02.add(77);
        GenercisLimits.addNumbers(intlist02);
        System.out.println("size is " + intlist02.size());

        // nelze pouzit metoda pracuje pouze List<Integer> a na predcich
        //List<String> strlist = new ArrayList<>();
        //GenercisLimits.addNumbers(strlist);

    }


}

