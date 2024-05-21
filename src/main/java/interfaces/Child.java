package interfaces;

public class Child implements HumanInteface {
    @Override
    public void printName() {
        System.out.println("child");
    }

    @Override
    public void printAge() {
        System.out.println(9);
    }
}