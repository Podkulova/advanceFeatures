package exceptions;

import java.util.Date;

public class MyException extends Exception{

    private final Integer exitcode = 14;

    private String className;
    private Date date;

    public MyException(String aclassName, String message){super(message);
        className = aclassName;
        date = new Date();
    }

    public String getClassName() {
        return className;
    }

    public Date getDate() {
        return date;
    }

    public Integer getExitcode() {
        return exitcode;
    }
}
