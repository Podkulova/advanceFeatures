package abstractclasses;

public class PersonalCarChildAbs extends ParentAbstractCar {


    @Override
    protected String carInfoFromChild() {
        return "PersonalCarChildAbs.carInfoFromChild";
    }

    @Override
    protected Integer carInfoLength() {
        return 888;
    }

    @Override
    protected Integer carInfoWidth() {
        return 555;
    }
}
