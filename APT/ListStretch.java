public class ListStretch {
    public ListNode stretch (ListNode list, int amount){
        
        if(list == null){
            return list;
        }
        ListNode head = new ListNode(list.info);
        ListNode tail = head;
        
        for (int i = 1; i < amount; i++) {
            tail.next = new ListNode(list.info);
            tail = tail.next; 
        }

       
        tail.next = stretch(list.next, amount);

       
        return head;
    }
}
