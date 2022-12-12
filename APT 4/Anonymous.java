import java.util.*;

public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {
        ArrayList<String> headWOSpace = new ArrayList<String>();
        for (String headX : headlines) {
            String[] hSplit = headX.split(" ");
            headWOSpace.addAll(Arrays.asList(hSplit));
        }
        String[] input = headWOSpace.toArray(new String[0]);
        int[] headChars = getCounts(input);

        int ret = 0;
        for (String messageX : messages) {
            String[] mSplit = messageX.split(" ");
            int[] messageChars = getCounts(mSplit);
            for (int i = 0; i < 300; i++) {

                if (headChars[i] < messageChars[i]) {
                    break;
                }
                if (i == 299) {
                    ret++;
                }
            }
        }

        return ret;
    }

    private int[] getCounts(String[] strings) {
        int[] counts = new int[300];
        for (String s : strings) {
            for (char ch : s.toLowerCase().toCharArray()) {
                counts[ch] += 1;
            }

        }
        return counts;
    }
}