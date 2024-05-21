package interfaces;

public class CarIntPersonal implements CarInterface {

    @Override
    public String getSPZ() {
        return "ABC-123-123";
    }

    @Override
    public String getCarType() {
        return "personal car";
    }

    @Override
    public Integer getLength() {
        return 4;
    }

    @Override
    public Integer getWith() {
        return 8;
    }


}
