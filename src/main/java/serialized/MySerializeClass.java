package serialized;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MySerializeClass implements Serializable {

    private String name = "";
    private Integer age = 0;
    private String address = "";
    private List<String> strList = new ArrayList<>();


    public MySerializeClass(String aname, Integer aage, String aaddress){
        name = aname;
        age = aage;
        address = aaddress;
    }
    @Override
    public String toString(){
        String sOut = name + " - " + age.toString() + " - " + address;
        for (String s : strList) {
            sOut += " [" + s + "]";
        }
        return sOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }
}
