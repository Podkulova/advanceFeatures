package threads;

public class GunFight {
    private int bullets = 0;

    private int zasobnik = 0;
    synchronized public void fire(int azasobnik, int bulletsToBeFired)
    {
        zasobnik = azasobnik;
        bullets = zasobnik;
        // ciklus od 0 do (bulletsToBeFired)
        // kdyz je bullets 0 zavolá metodu wait (zastavi se vlakno)
        // pak pokracuje az do (bulletsToBeFired)

        for (int i = 1; i <= bulletsToBeFired; i++) {
            System.out.println(i - 1 + " BUM zbyva " + bullets + " naboju");
            if (bullets == 0) {
                System.out.println("volame wait()");
                try {
                    // zastavi vlakno a ceka na zavolani notiy (zde se notfy vola v metode reload())
                    wait(); // metoda z Object
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("pokracujeme po nabiti");
            }
            bullets--;
        }
        System.out.println("KONEC");
    }

    synchronized public void reload()
    {
        // zavolanim metody notify vlako pokracuje v praci (v tomto pripade na radku 17)
        System.out.println("nabijime  notify()");
        bullets = zasobnik;
        notify();
    }
}