package abstractclasses;

public class MainAbstract {

    public static void main(String[] args) {

        // test abstraktni tidy - děděni
        abstractTest();

        // použití anonymní třídy
        abstractAnonymTest();

    }

    public static void abstractTest() {

        // vytváříme dvě instance děděné z abstraktní třídy a voláme jejich metodu

        PersonalCarChildAbs absPersonal = new PersonalCarChildAbs();
        System.out.println(absPersonal.getCarrInfo());

        VanCarChildAbs absvan = new VanCarChildAbs();
        System.out.println(absvan.getCarrInfo());
    }


    public static void abstractAnonymTest() {

        // třída se deklaruje přímo zde - nikoli v samostatném kódu
        ParentAbstractCar abs = new ParentAbstractCar() {
            @Override
            protected String carInfoFromChild() {
                return "";
            }

            @Override
            protected Integer carInfoLength() {
                return 5;
            }

            @Override
            protected Integer carInfoWidth() {
                return 4;
            }
        };

        System.out.println(abs.getCarrInfo());
    }

}
