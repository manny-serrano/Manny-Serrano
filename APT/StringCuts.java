import java.util.ArrayList;
import java.util.List;

public class StringCuts {
    public String[] filter(String[] list, int minLength) {
        List<String> wordlist = new ArrayList<> ();

        for(String word : list){
            if(word.length() >= minLength && !wordlist.contains(word)){
                wordlist.add(word);
            }
            
        }
        return  wordlist.toArray(new String [0]);
    }
}
