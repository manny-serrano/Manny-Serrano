import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class AlphaLength {
    public ListNode create (String[] words) {
       Arrays.sort(words);
        Set<String> wordset = new LinkedHashSet<>(Arrays.asList(words));
        ListNode head = null;
        ListNode end = null; 
       
       for(String a: wordset){

        ListNode node = new ListNode(a.length());
        if(head == null){
        head = node;
        end = node;

        }
        else{

            end.next = node;
            end = node;
        }
       }
       
       
    return head;
    
}
}
