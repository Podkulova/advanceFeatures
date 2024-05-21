package generisc;


/*
    konvence pojmenovani (<T> za nazvem tridy=typ)
    dalsi mozne :

    E- Element (používá se např. pro Java Collection API)
    K- Klíč
    N- Číslo
    T- Typ
    V- Hodnota
*/

public class GenBox<T> {
    private T item;

    public GenBox(){
    }

    public GenBox(T item){
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

