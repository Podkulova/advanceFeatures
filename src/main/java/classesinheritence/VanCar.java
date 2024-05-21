package classesinheritence;

// potomet hlavni tridy
public class VanCar extends Car {

    public VanCar(String aStrCar){
        super(aStrCar);
    }

    @Override
    public void printType(){
        System.out.println(stringCar + " nakladni vozidlo obecne");
    }

    public void printSize(){
        System.out.println("           - nespecifikovano");
    }

}
