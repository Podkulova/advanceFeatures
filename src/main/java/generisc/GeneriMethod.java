package generisc;

public class GeneriMethod {

    // metoda generuje třídu Pair na vstupu jsou generické parametry
    public static <K, V> Pair<K, V> generatePair(K key, V value) {
        Pair<K, V> pair = new Pair<K, V>();
        pair.setKey(key);
        pair.setValue(value);
        return pair;
    }

    // <T> = konzumuje typ
    // String = vrací String

    public static <T> String getString(T data) {
        return ">>> " + data.toString() + "<<<";
    }

}
