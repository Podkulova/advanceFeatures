package enums;

// Ukazka prace s Enum
public class MainEnums {
    // klasicke konstanty, tyto popisuji stejny objekt (color) jineho typu
    // v takovem pripade je lepsi pouzit Enum
    private static final String COLOR_RED  = "RED";
    private static final String COLOR_BLUE  = "BLUE";

    public static void main(String[] args) {
        pritIt(BasicColorsEnum.BLACK);
        constTest();
        enmTest(ColorsEnum.BLUE);


        System.out.println(ColorsAdvancedEnum.GREEN.getColorName());
        ColorsAdvancedEnum enumAdv = ColorsAdvancedEnum.BLACK;
        System.out.println(enumAdv.getColorName());
    }

    // vypise polozku podle enum
    public static void pritIt(BasicColorsEnum colorenum){

        if(colorenum== BasicColorsEnum.BLACK) {
            System.out.println("je to cerna");
        }
        else {
            System.out.println("to neni cerna");
        }
    }

    // pouziti konstant - lepe pouzit enum
    public static void constTest(){

        // rozhodovani podle hodnoty a konstanty
        String color = COLOR_BLUE;

        // na základě hodnoty provedeme nějakou cinnost
        if(color.equalsIgnoreCase(COLOR_BLUE)){
            System.out.println("je to modrá");
        }else if(color.equalsIgnoreCase(COLOR_RED)){
            System.out.println("je to červená");
        }

    }

    public static void enmTest(ColorsEnum clrsenum){

        // obdrzime enum ve vstupním parametru

        // na základě jeho typu (enumu) provedeme nějakou cinnost
        if(clrsenum == ColorsEnum.BLUE){
            System.out.println("je to modrá");
        }else if(clrsenum == ColorsEnum.BLUE){
            System.out.println("je to červená");
        }else
            System.out.println("jina barva");

        // enum má v sobě i popis tak ho vytiskneme
        System.out.println("caption in enum for color is="+clrsenum.getColorName());

    }


}
