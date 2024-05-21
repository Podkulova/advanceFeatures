package classesinheritence;

public class VanBigger extends VanCar{


    public VanBigger(){
        super(">>>VAN BIGGER CUSTOM<<<");
    }


    @Override
    public void printType(){
        System.out.println(stringCar + " nakladni vozidlo NEJVETSI  spz=" + SPZ);
    }

    @Override
    public void printSize(){
        System.out.println("           - nad 10 tun");
    }


}
