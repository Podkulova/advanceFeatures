package interfaces;

// Interface (rozhraní)
public class MainInterfaces {


    public static void main(String[] args) {
        intTest();
        implementInMethod();
        getInterface(1);
        interfaceMethodsCall();
    }
    public static void intTest(){

        CarInterface carInterface01;

        carInterface01 = getInterface(1); // personal
        printInfo(carInterface01);

        carInterface01 = getInterface(10); // van
        printInfo(carInterface01);

    }

    public static void implementInMethod(){

        // implementace rozhrani prim zde v vkodu
        CarInterface carInterface = new CarInterface() {
            @Override
            public String getSPZ() {
                return "SPZ-321654987";
            }

            @Override
            public String getCarType() {
                return "bmw";
            }

            @Override
            public Integer getLength() {
                return 5;
            }

            @Override
            public Integer getWith() {
                return 2;
            }
        };
        printInfo(carInterface);

    }



    // vytvori a vrati implementaci rozhrani dle parametru
    // implemntace je potomek CarIntPersonal nebo CarIntVan
    private static CarInterface getInterface(int cartype){

        if(cartype==1)
            return new CarIntPersonal();
        else
            return new CarIntVan();
    }

    // metoda pouziva rozhrani nezavisle na tom co ji implementuje
    // CarIntPersonal nebo CarIntVan
    private static void printInfo(CarInterface carInterface){
        System.out.println(carInterface.getSeparator());
        System.out.println(carInterface.getSPZ());
        System.out.println(carInterface.getCarType());
        System.out.println(carInterface.getLength());
        System.out.println(carInterface.getWith());

    }


    public static void interfaceMethodsCall() {

        // pokud mame promennou typu interface lze volat jen metody interface
        HumanInteface old = new OldMan();
        HumanInteface child = new Child();

        System.out.println("---- OLD ----");
        old.printName();
        old.printAge();

        System.out.println("---- CHILD ----");
        child.printName();
        child.printAge();

        // pokud mame promennou typu trida implementujici interface, lze volat metody interface
        // a take metody z dane tridy - zde "printAddress()"
        OldMan old2 = new OldMan();
        System.out.println("---- OLD 2 ----");
        old2.printName();
        old2.printAge();
        old2.printAddress();

    }

}
