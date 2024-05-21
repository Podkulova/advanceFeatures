package generisc;


// tato genericka trida deklaruje více generik <K, V>
// K=klíč, V=hodnota. Můžou být libovolného typu
public class Pair<K, V> {

    private K key;
    private V value;

    public Pair(){
    }

    public Pair(K akey, V avalue){
        key = akey;
        value = avalue;
    }


    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
