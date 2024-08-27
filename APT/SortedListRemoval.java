public class SortedListRemoval {

    public ListNode uniqify(ListNode list){
        if(list==null){
            return null;
        }
    ListNode head = list;
    ListNode first = head;
    ListNode current = head.next;
    
    
    while(list != null && current!=null){
    if(first.info == current.info){
        head = head.next;
        first = head; 
        current=current.next;
    }
    else{
        first = first.next;
        current = current.next;
    }

    }
    return head;
}
}

