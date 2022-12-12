public class DoubleList {
    public ListNode bigify(ListNode list) {
        if (list == null) {
            return null;
        }
        ListNode ret = new ListNode(list.info);
        ListNode doubled = ret;
        boolean checker = true;

        while (list != null) {
            if (checker) {
                ret.next = new ListNode(list.info);
                ret = ret.next;
                checker = false;
            } else {
                ret.next = new ListNode(list.info);
                ret = ret.next;
                ret.next = new ListNode(list.info);
                ret = ret.next;
            }
            list = list.next;

        }
        return doubled;
    }
}
