import java.util.*;
public class MedalTable {


   static class Country implements Comparable<Country> {
       String code;
       int[] medals = new int[3];


       public Country(String code) {
           this.code = code;
       }
       @Override
       public int compareTo(Country o) {
           for (int i = 0; i < 3; i++) {
               if (this.medals[i] != o.medals[i]) {
                   return o.medals[i] - this.medals[i];
               }
           }
           return this.code.compareTo(o.code);
       }
       @Override
       public String toString() {
           return String.format("%s %d %d %d", code, medals[0], medals[1], medals[2]);
       }
   }
   public String[] generate(String[] results) {
       Map<String, Country> map = new HashMap<>();
       for (String r : results) {
           String[] res = r.split(" ");
           for (int i = 0; i < 3; i++) {
               map.computeIfAbsent(res[i], Country::new).medals[i]++;
           }
       }
       return map.values().stream()
               .sorted()
               .map(Country::toString)
               .toArray(String[]::new);
   }
}
