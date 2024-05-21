package accessmodifier.mainpkg;

import java.util.Random;

public class AccModifMainObject {

    public Integer randomInteger = 0;


    public AccModifMainObject(){

        Random rand = new Random();
        randomInteger = rand.nextInt(1000);
    }
}
