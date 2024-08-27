import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class SetAside {
    public String common(String[] list) {
        HashSet<String> words = new HashSet<>();
        ArrayList<String> commonword = new ArrayList<>();
        
        for(String a: list){
             ArrayList<String> newlist = new ArrayList<String>(Arrays.asList(a.split(" "))); 
             for(String b: newlist){
                    words.add(b);
             }
        }

       HashMap<String, Integer> countword = new HashMap <>();
        for(String word: words){
            int count = 0;
            for(String element : list){
                if (element.contains(word)){
                    count++;
                    countword.put(word, count);

                }
            }
        
        }

        for(String key: countword.keySet()){
            if (countword.get(key)== list.length){
                commonword.add(key);

            }
        }

        Collections.sort(commonword);
        

        return String.join(" ", commonword);
    }
}
