package enums;

public enum ColorsAdvancedEnum {
    RED("red color", 56847),
    WHITE("white color", 3218974),
    BLACK("black color", 458745),
    BLUE("blue color", 11111),
    GREEN("green color", 22222);

    private String colorName;
    private Integer rgb;
    ColorsAdvancedEnum(String aColorName, Integer aRgb){
        colorName = aColorName;
        rgb = aRgb;
    }

    public String getColorName() {
        return colorName;
    }
}
