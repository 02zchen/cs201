import java.util.*;

public class CounterAttack {
    public int[] analyze(String str, String[] words) {
        String[] arr = str.split(" ");

        int[] intArray = new int[words.length];
        int i = 0;
        for (String x : words) {
            intArray[i] = Collections.frequency(Arrays.asList(arr), x);
            i++;
        }
        return intArray;
    }

}