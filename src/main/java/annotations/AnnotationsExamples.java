package annotations;

import java.time.Month;

@PersonInfo(names = {}, dates = "12-12-2022")
public class AnnotationsExamples {

    @ComponentInfo(name = "annotationsExamples", date = "12-10-2020", currentRevision = 2)
    private String someField;


    public AnnotationsExamples(@InputArgs(doubleValue = 7) final String someField) {
        //intValue is set to the default
        this.someField = someField;
    }
}