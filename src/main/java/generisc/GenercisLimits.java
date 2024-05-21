package generisc;

import java.util.List;

public class GenercisLimits{

    // Konstrukce <? extends Number> je tzv horni limit
    // pracuje jen s objekty ktere jsou dedene z Number
    public static double sum(final List<? extends Number> numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    // konstrukce <? super Integer> je tzv dolni limit
    // pracuje jen s typem Integer a nebo jeho predkem
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

}
