package annotations;

public @interface InputArgs {
    int intValue() default 2; // the default value of the intValue field if omitted is 2
    double doubleValue();     // no default value, required field
}