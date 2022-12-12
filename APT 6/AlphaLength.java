import java.util.*;

public class AlphaLength {
    public ListNode create(String[] words) {

        HashSet<String> noDupes = new HashSet<>(Arrays.asList(words));
        TreeSet<String> alphaOrder = new TreeSet<String>(noDupes);
        String[] sortedWords = alphaOrder.toArray(new String[alphaOrder.size()]);
        ListNode ret = new ListNode(sortedWords[0].length());
        ListNode temp = ret;

        for (int i = 1; i < sortedWords.length; i++) {
            ret.next = new ListNode(sortedWords[i].length());
            ret = ret.next;
        }
        return temp;
    }

}