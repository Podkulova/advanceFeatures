package annotations;

import java.time.Month;

public @interface PersonInfo {
    String[] names();
    String[] dates();

}