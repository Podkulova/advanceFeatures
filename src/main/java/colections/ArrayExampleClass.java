package colections;

public class ArrayExampleClass {

    protected String[] strArray;
    protected DataClass[] dataArray;

    public ArrayExampleClass(){
        strArray = new String[10];
        dataArray = new DataClass[10];
    }

    public void setData(Integer index, DataClass data){
        if(index>=0 && index<10)
            dataArray[index] = data;
    }

}
