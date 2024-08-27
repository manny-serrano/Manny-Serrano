
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Aaagmnrs {
    public String[] anagrams(String[] phrases) {
       LinkedHashSet<String> anagram = new LinkedHashSet<>();
      ArrayList <String> phraseslist = new ArrayList<>();
       for(String word: phrases){
      
         String wordtrimmed = word.replaceAll("\\s+", "");
         String lowerword = wordtrimmed.toLowerCase();
         char[] splitword = lowerword.toCharArray(); 
         Arrays.sort(splitword);
         String sortedword = new String(splitword);
         
         if(!phraseslist.contains(sortedword)){
            anagram.add(word);
            phraseslist.add(sortedword);
         }
         
    }

    return anagram.toArray(new String[0]);
 }
}