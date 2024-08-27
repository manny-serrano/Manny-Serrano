import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class SortedFreqs {
    public int[] freqs(String[] data) {
      // fill in code here
        Map <String, Integer> newmap = new HashMap <>(); 

      for(String a: data){
        if (newmap.containsKey(a)){
            newmap.put(a, newmap.get(a) +1);
        }
        if(!newmap.containsKey(a)){
            newmap.put(a, 1);

        }
       
      }

      Arrays.sort(data); 
      TreeSet <String> newset = new TreeSet<>(Arrays.asList(data)); 
      List <Integer> numbers = new ArrayList<>();

      for(String b : newset){
        numbers.add(newmap.get(b)); 
      }
      int[] numbersarray = new int[numbers.size()];
      for (int x = 0; x < numbers.size(); x++) {
          numbersarray[x] = numbers.get(x);
      }

      return numbersarray;

    }
 }
