package classinclass;

public class TestCls {

    public static class InClassStatic {
        public String jmeno;
    }

    protected class InClass {
        public String jmeno;
    }

    public void doThat(){
        InClass i = new InClass();
    }


}
