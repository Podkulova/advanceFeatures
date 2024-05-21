package functional;

/*
   @FunctionalInterface = Jakékoli rozhraní s SAM (Single Abstract Method) je funkční rozhraní
   a jeho implementace může být považována za výrazy lambda, muze obsahovat pouze jednu metodu
*/
@FunctionalInterface
public interface FuncInterface {
    void abstractFun(int x);

    // jedine metodyy defaul mohou byt u rozhrani @FunctionalInterface
    // mohla by se pouzit tak ze zpracuje data a mimo jine i vola metodu
    // funkcniho rozhrani (zde abstractFun)
    default int min(int a, int b) {
        return a < b ? a : b;
    }
}
