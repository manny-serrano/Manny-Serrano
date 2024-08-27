import java.util.*;
public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {
          HashMap<Character, Integer> characters = new HashMap<Character, Integer>();
          for(String headline: headlines){
            headline = headline.toLowerCase();
            for (int i = 0; i < headline.length(); i++) {
                if(headline.charAt(i) == (' ')){
                    continue;
                }
                characters.putIfAbsent(headline.charAt(i), 0);
                characters.put(headline.charAt(i), characters.get(headline.charAt(i))+1);
            }
          }


          int result = 0;
          for(String message: messages){
            message = message.toLowerCase();
            boolean add1 = true;
            HashMap<Character, Integer> current = new HashMap<>(characters);
            for (int i = 0; i < message.length(); i++) {
                if(message.charAt(i) == (' ')){
                    continue;
                }
                current.putIfAbsent(message.charAt(i), 0);
               
                if(current.get(message.charAt(i)) == 0){
                    add1 = false;
                    break;
                }
               
                current.put(message.charAt(i), current.get(message.charAt(i))-1);
            }
            if(add1) result++;
          }


          return result;
    }
 }


