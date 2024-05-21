package abstractclasses;

// ABSTRAKTNI TRIDA SE NEDA VYTVORIT POMOCI (NEW)
public abstract class ParentAbstractCar {
    // -------------------------------------------
    public String getCarrInfo(){
        return " info=" + carInfoFromChild() + " len=" + carInfoLength();
    }
    public Integer getArea(){
        return carInfoLength() * carInfoWidth();
    }

    // ABSTRAKTNI METODY KTERE SE MUSI IMPLEMENTOVAT V POTOMKOVI
    protected abstract String carInfoFromChild();
    protected abstract Integer carInfoLength();
    protected abstract Integer carInfoWidth();
    // --------------------------------------------------------
    protected String getCar(){
        return "CAR ";
    }

}
