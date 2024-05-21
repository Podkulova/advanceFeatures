package classinclass;

public class MainClsInCls {

    public static void main(String[] args) {

        // zde je třída TestCls která má v sobě deklarovanou
        // další třídu InClassStatic
        TestCls.InClassStatic inerclass = new TestCls.InClassStatic();
        inerclass.jmeno = "karel";
        System.out.println(inerclass.jmeno);

        // zde je deklarace třídy, a to přímo v této metodě
        // lze tedy použít také jen v této metodě
        class InMethodClass {
            String key;
            int value;
        }
        // zde je pak její použití
        InMethodClass inMethodClass = new InMethodClass();
        inMethodClass.key = "hodnota";
        inMethodClass.value = 123;
        System.out.println(inMethodClass.key);

    }


}
