public class PairDown {
    public int[] fold(int[] list) {
        int[] ret;
        int counter = 0;
        if (list.length % 2 == 1) {
            ret = new int[(list.length / 2) + 1];
            for (int i = 0; i < list.length - 1; i += 2) {
                ret[counter] = list[i] + list[i + 1];
                counter++;
            }
            ret[(list.length / 2)] = list[list.length - 1];
        } else {
            ret = new int[list.length / 2];
            for (int i = 0; i < list.length; i += 2) {
                ret[counter] = list[i] + list[i + 1];
                counter++;
            }
        }

        return ret;
    }
}