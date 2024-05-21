package accessmodifier;

// ukázka modifikátorů přístupu, není zde žádná spustitelná metoda
// jde jen o popis deklarace
public class MyClass {

    // default (nezadano) = pristup ze stejne tridy a trid stejneho baliku
    // public = pristup libovolny,
    // private = pristup jen ze stejne tridy
    // protected = jako default + pristup ze vsech potomku teteo tridy

    private Integer cislo;

    public MyClass(Integer aCislo){
        cislo = aCislo + 222;
    }

    // nejaka funkcnost ktera manipuluje s promennou cislo je nekde v teto tride

    public void setCislo(Integer acislo){ // setter
       // if(acislo!=null)
       // if(acislo<100)
           cislo = acislo;
    }

    public Integer getCislo() {
        return cislo;
    } // getter
}
