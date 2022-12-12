import java.util.*;

public class LengthSort {
    public String[] rearrange(String[] values) {
        // sorts by shortest strings first, same length in a
        Arrays.sort(values, Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        return values;
    }
}
