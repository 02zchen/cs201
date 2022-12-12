
public class ListStretch {
    public ListNode stretch(ListNode list, int amount) {
        if (list == null) {
            return list;
        }
        ListNode ret = new ListNode(list.info);
        ListNode expand = ret;
        boolean checker = true;
        while (list != null) {
            if (checker) {
                for (int i = 0; i < amount - 1; i++) {
                    ret.next = new ListNode(list.info);
                    ret = ret.next;
                }
                checker = false;
            } else {
                for (int i = 0; i < amount; i++) {
                    ret.next = new ListNode(list.info);
                    ret = ret.next;
                }
            }

            list = list.next;
        }
        return expand;
    }

}
