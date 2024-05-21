package interfaces;

public class OldMan implements HumanInteface {

    private String localStr = "";

    public OldMan(){
    }

    public OldMan(String str){
        localStr = str;
    }

    @Override
    public void printName() {
        System.out.println(localStr +  " - old man");
    }

    @Override
    public void printAge() {
        System.out.println(33);
    }

    public void printAddress(){
        System.out.println("Vranov");
    }

}
