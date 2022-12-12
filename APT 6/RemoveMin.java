public class RemoveMin {
    public ListNode remove(ListNode list) {
        // finds the smallest value within the list, saves intial spot using copy
        ListNode copy = list;
        ListNode ret = list;
        int least = list.info;
        while (list != null) {
            if (list.info < least) {
                least = list.info;
            }
            list = list.next;
        }
        System.out.println(least);

        // reset pointer to intial node
        list = copy;

        // loop through list again, when the next node is the value, redirect the next
        // node

        while (list != null) {

            // if list only one character long, set ret null and break
            if (list.info == least && list.next == null) {
                ret = null;
                break;
            }
            // if the least value is at any other value
            // point next node to null
            if (list.next.info == least) {
                list.next = list.next.next;
                break;
            }

            // if the least value is at the very front and there is more after, set return
            // pointer to second

            else if (list.info == least) {
                ret = list.next;
                break;
            }

            list = list.next;
        }

        return ret;
    }

}

/*
 * System.out.println(list);
 * while (list != null) {
 * if (list.info == least) {
 * // if least is at end of the list, set the end of the list to one before
 * if (list.next == null) {
 * list = null;
 * break;
 * }
 * //if least is at the start of the list,
 * else{
 * list
 * }
 * }
 * 
 * else if (list.next.next == null) {
 * list.next = null;
 * }
 * 
 * else if (list.next != null && list.next.info == least) {
 * list.next = list.next.next;
 * }
 * list = list.next;
 * }
 */