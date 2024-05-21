package constructors;

public class ParentClass {

    private String name = "";
    private DataClass data;

    public ParentClass() {
        name = "empty name";
    }
    public ParentClass(DataClass datac) {
        data = datac;
    }

    public ParentClass(DataClass datac, String aname) {
        data = datac;
        name = aname;
    }
    public ParentClass(String aName){
        name = aName;
    }
    public ParentClass(String prefix, String aName){
        name = prefix + ": " + aName;
    }
    public String getName() {
        return name;
    }

}
