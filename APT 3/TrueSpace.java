public class TrueSpace {
    public long calculateSpace(int[] sizes, int clusterSize) {
        long diskSpace = 0;
        long remainder;
        for (int i = 0; i < sizes.length; i++) {
            remainder = sizes[i] % clusterSize;
            diskSpace += sizes[i] / clusterSize;
            if (remainder != 0) {
                diskSpace++;
            }

        }
        return diskSpace * clusterSize;
    }
}
