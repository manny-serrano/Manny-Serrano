
public class MergeLists {
    public ListNode weave(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        ListNode head = a; 

        while (a != null && b != null) 
        {
            ListNode aNext = a.next; 
            ListNode bNext = b.next;

            a.next = b; 

            if (aNext == null) 
            {
                break; 
            }

            b.next = aNext; 

            a = aNext;
            b = bNext;
        }

        return head;
    }
}
