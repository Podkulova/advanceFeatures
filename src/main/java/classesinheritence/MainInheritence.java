package classesinheritence;

public class MainInheritence {

    public static void main(String[] args) throws Exception {

        // DEDENI
        // ***************************************************

        // hlavni nadrizena trida
        Car carclas = new Car(">>>nespecifikovano<<< ");
        carclas.printType();

        // trida zdedena z tridy Car
        PersonalCar personal01 = new PersonalCar(">>>SPECIF STR<<< ");
        personal01.printType();

        // Jina trida zdedena z tridy Car
        PersonalCar personal = new PersonalCar();
        personal.printType();

        // Jina trida zdedena z tridy Car
        VanCar van = new VanCar(">>>VAN<<<");
        van.printType();
        van.printSize();

        // trida zdedena z tridy VanCar ktera je zdedena z tridy Car
        VanBigger vanBigger = new VanBigger();
        vanBigger.setSPZ("SPZZZZZZZ");

        vanBigger.printType();
        vanBigger.printSize();

        // IMPLEMENTACE NADRIZENE METODY
        // ***************************************************
        // tridy jsou zdedene a volaji dedi metodu
        // pokud ji nezdeddi nadrizena trida vyhodi chybu
        Child01 ch1 = new Child01();
        Child02 ch2 = new Child02();
        Child03 ch3 = new Child03();

        System.out.println(ch1.getName());
        System.out.println(ch2.getName());
        //System.out.println(ch3.getName()); // tato metoda getName - vyhodi chybu - trida neimplementuje metodu


    }
}
