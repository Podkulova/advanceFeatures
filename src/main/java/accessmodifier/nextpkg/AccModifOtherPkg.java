package accessmodifier.nextpkg;

import accessmodifier.mainpkg.AccModifMainObject;

public class AccModifOtherPkg {

    public void method(){
        AccModifMainObject o = new AccModifMainObject();
        System.out.println(o.randomInteger);
    }
}
