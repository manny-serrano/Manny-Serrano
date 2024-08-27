import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Thesaurus {
    public String[] edit(String[] entry) {
       ArrayList<Set <String>> words = new ArrayList<>();

       for(String a: entry){

        HashSet<String> stringset = new HashSet <>(Arrays.asList(a.split(" ")));
        words.add(stringset);
       }

       boolean merged = true;

       while(merged)
    {
        merged = false;

        for(int a = 0; a< words.size(); a++){
            if (merged){

                break;
            }
            for(int b=a+1; b<words.size(); b++){
                Set<String> merge = new HashSet<>(words.get(a));
                merge.retainAll(words.get(b));

                if(merge.size() >=2){

                    Set<String> mergedSet = new HashSet<>(words.get(a));
                    mergedSet.addAll(words.get(b));
                    words.set(a, mergedSet);
                    words.remove(b);

                    merged = true;
                    break;
                }
            }

        }
    }


        List<String> sortedwords = new ArrayList<>();

            for (Set<String> wordSet : words) {
    
                List<String> wordlist = new ArrayList<>(wordSet);
                Collections.sort(wordlist); 

    
                StringBuilder entryBuilder = new StringBuilder();
            for (String word : wordlist) {
                 if (entryBuilder.length() > 0) entryBuilder.append(" ");
                    entryBuilder.append(word);
                 }
                sortedwords.add(entryBuilder.toString());
                 }
                Collections.sort(sortedwords);
                String[] result = sortedwords.toArray(new String[0]);

        return result;
       
    }
}