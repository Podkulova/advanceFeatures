package enums;

public enum ColorsEnum {
    RED("red color"),
    WHITE("white color"),
    BLACK("black color"),
    BLUE("blue color"),
    GREEN("green color");

    private String colorName;

    ColorsEnum(String aColorName){

        colorName = aColorName;
    }
    public String getColorName() {
        return colorName;
    }
}
