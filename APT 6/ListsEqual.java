public class ListsEqual {
    public int equal(ListNode a1, ListNode a2) {
        int ret = 1;

        while (a1 != null && a2 != null) {
            if (a1.info != a2.info) {
                ret = 0;
                break;
            } else {
                a1 = a1.next;
                a2 = a2.next;
            }
        }
        if (a1 == null && a2 != null || a1 != null && a2 == null) {
            ret = 0;
        }
        return ret;
    }
}
