import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reduplication {
    public int count(String[] words) {
      
      HashMap<String, String> newmap= new HashMap<>();
      for(String a: words){
        if(a.contains("-") && (a.substring(0, a.indexOf("-")).equals(a.substring(a.indexOf("-")+1,a.length() )))){
            if(!newmap.containsKey(a))
            newmap.put(a, a.substring(0, a.indexOf("-")));

        }
      }
      int count =0;
      for(String b : newmap.keySet()){
        for(String c: words){
            if(c.equals(newmap.get(b))){
                count++;
            }
        }
      }

     
    
        
       



      return count;
    }
   
}
