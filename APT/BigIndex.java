public class BigIndex {
    public ListNode filter(ListNode list) {
        
       
        
        ListNode current = list; 
        ListNode prev = list; 
        int count = 0; 
        if(list == null){
            return null; 
        }
        while(current !=null){

            if(current.info < count){
                
                prev.next = current.next; 
                
            }
            else {
                prev=current; 
            
            
        }
        current=current.next; 
        count++; 
    }
       
        return list;
    
}
}
