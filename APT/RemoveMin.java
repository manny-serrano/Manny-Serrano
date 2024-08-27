public class RemoveMin {
    public ListNode remove (ListNode list) {
        if(list ==null){
            return null; 
        }
    ListNode first = list;
    int minimum = Integer.MAX_VALUE; 
    

    while(first!=null){
        if(first.info < minimum){
            minimum = first.info;

        }
        first = first.next;

    }
   

    if(list.info == minimum){
        return list.next;
    }
    
    first = list;

    while(first.next != null){
        if(first.next.info == minimum){
            first.next = first.next.next;
            break;
        }
        first= first.next;
    }
    return list;
    }



}
