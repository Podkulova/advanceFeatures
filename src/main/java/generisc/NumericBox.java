package generisc;

// trida definuje generiku. A to jen takovy typ ktery je dedeny z Number
public class NumericBox<T extends Number> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
