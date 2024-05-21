package functional;

public class Employee {
    private String name;
    public Employee(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getNameAndSuffix(){
        return name + "-suffix";
    }
}