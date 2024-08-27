import java.util.*;
public class SortByFreqs {


   public String[] sort(String[] data) {
       
       Map<String, Integer> newmap = new HashMap<>();
       for (String str : data) {
           newmap.put(str, newmap.getOrDefault(str, 0) + 1);
       }
       List<String> sortedList = new ArrayList<>(newmap.keySet());
       sortedList.sort((a, b) -> {
           int compare = newmap.get(b).compareTo(newmap.get(a));
           if (compare == 0) {
               return a.compareTo(b);
           }
           return compare;
       });
       return sortedList.toArray(new String[0]);
   }
}
