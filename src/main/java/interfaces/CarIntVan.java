package interfaces;

public class CarIntVan implements CarInterface {

    @Override
    public String getSPZ() {
        return "CCC-999-123";
    }

    @Override
    public String getCarType() {
        return "van car";
    }

    @Override
    public Integer getLength() {
        return 14;
    }

    @Override
    public Integer getWith() {
        return 3;
    }
}
