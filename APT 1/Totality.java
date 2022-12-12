public class Totality {
    public int sum(int[] a, String stype) {
        int counter = 0;
        if (stype.equals("odd")) {
            for (int i = 0; i < a.length; i++) {
                if (i % 2 == 1) {
                    counter += a[i];
                }
            }
        } else if (stype.equals("even")) {
            for (int i = 0; i < a.length; i++) {
                if (i % 2 == 0) {
                    counter += a[i];
                }
            }

        } else if (stype.equalsIgnoreCase("all")) {
            for (int i = 0; i < a.length; i++) {
                counter += a[i];
            }
        }
        return counter;
    }
}