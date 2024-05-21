package classesinheritence;

public class ParentClass {

    public String getName() throws Exception {
        return nameFromChild();
    }

    protected String nameFromChild() throws Exception {
        throw new Exception();
    }
}
