package generisc;

public class GenCup<T> {
    private final T liquid;

    public GenCup(T liquid) {
        this.liquid = liquid;
    }

    void drink() {
        System.out.print("Drinking ");
        System.out.println(liquid);
    }
}
