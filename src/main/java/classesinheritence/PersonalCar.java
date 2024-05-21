package classesinheritence;

// potomet hlavni tridy
public class PersonalCar extends Car {

    public PersonalCar(String aStrCar) {
        super(aStrCar);
    }

    public PersonalCar(){
        super(">>DEF<< ");
    }

    @Override
    public void printType(){
        System.out.println(stringCar + " osobni vozidlo");
    }
}
