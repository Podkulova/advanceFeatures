package colections;

import javax.xml.crypto.Data;

public class DataClass {

    public String name = "";
    public Integer age = 1;

    public DataClass(String aName, Integer aAge){
        name = aName;
        age = aAge;
    }

    @Override
    public String toString(){
        return "[" + name + "] [" + age.toString() +  "]";
    }

    @Override
    public boolean equals(Object o) {
        return ((DataClass) o).age == age;
    }

    @Override
    public int hashCode(){
        return age;
    }
}
