package classesinheritence;

// hlavni trida ze ktere budeme dedit

import annotations.SimpleAnotation;

@SimpleAnotation
public class Car {

    protected String stringCar;
    protected String SPZ = "";

    public Car(){
        stringCar = "aStrCar";
    }

    public Car(String aStrCar){
        stringCar = aStrCar;
    }

    public void printType(){
        System.out.println(stringCar + " >>> nespecifikovane vozidlo <<<");
    }

    public void setSPZ(String SPZ) {
        SPZ = SPZ;
    }


}
