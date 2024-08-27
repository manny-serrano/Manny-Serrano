import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Follower {
    public int[] follows(String[] words) {
       HashMap <String, Integer> newmap = new HashMap<>();
       ArrayList<String> newlist = new ArrayList<>(Arrays.asList(words)); 
       ArrayList<Integer> numbers = new ArrayList<>(); 
       for(String a: words){
        if(newmap.containsKey(a)){

            newmap.put(a, newmap.get(a) + 1); 
        }

        if(!newmap.containsKey(a)){
            newmap.put(a, 1);

        }

        


       }
       for(String b: newlist){
        if(newmap.get(b)>=2){
            numbers.add(newlist.indexOf(b));
        
        }
        

       }
       int[] integers = new int[numbers.size()];
       for (int i = 0; i < numbers.size(); i++) {
           integers[i] = numbers.get(i);
       }
       return integers;
        }

        

       }


  
