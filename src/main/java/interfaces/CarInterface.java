package interfaces;

public interface CarInterface {

    default String getSeparator(){
        return "----------------------------------------------";
    }

    default String getSPZAndLengt(){
        return getSPZ() + "-----" + getLength();
    }

    // ----------------------------------------
    String getSPZ();
    String getCarType();
    Integer getLength();
    Integer getWith();
    // ----------------------------------------

}
