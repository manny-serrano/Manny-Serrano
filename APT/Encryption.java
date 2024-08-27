
import java.util.HashMap;

import java.util.Map;


public class Encryption {
    public String encrypt(String message){
        char[] b = message.toCharArray();
       String al = "abcdefghijklmnopqrstuvwxyz";
       Map<Character, Character>wordmap = new HashMap<>();
       String encrypted = "";
       int index = 0;
        for(char a : b){
            
                if(!wordmap.containsKey(a)){
                    wordmap.put(a, al.charAt(index++));
                }

                
                encrypted += wordmap.get(a);
            }
            return encrypted;
        }
     
}
