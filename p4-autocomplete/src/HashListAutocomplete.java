import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class HashListAutocomplete implements Autocompletor {
    private static final int MAX_PREFIX = 10;
    private Map<String, List<Term>> myMap;
    private int mySize;


    public HashListAutocomplete(String[] terms, double[] weights) {
        if (terms ==null || weights== null){
            throw new NullPointerException("One or more things null");
        }
        initialize(terms, weights);
    
    }

    @Override
    public List<Term> topMatches(String prefix, int k) {
        if(!myMap.containsKey(prefix)){
            return new ArrayList<>();
        }
        if(prefix.length()> MAX_PREFIX){
            prefix = prefix.substring (0, MAX_PREFIX);
        }
        List<Term> allK = myMap.get(prefix);

        return myMap.get(prefix).subList(0,Math.min(k, allK.size()));
    }

    @Override
    public void initialize(String[] terms, double[] weights) {
        myMap = new HashMap<>();
        for(int i =0; i< terms.length; i++){
            String termWord = terms[i];
            double weight = weights[i];

            Term term = new Term (termWord, weight);
            int greatestIndex = Math.min(termWord.length(), MAX_PREFIX);

            for(int x = 0; x<=greatestIndex; x++){
                String substring = termWord.substring(0, x);
                myMap.putIfAbsent(substring, new ArrayList<>());
                myMap.get(substring).add(term);
                

            }


        }
        for(String k: myMap.keySet()){
            Collections.sort(myMap.get(k), (Comparator.comparing(Term:: getWeight).reversed()));
        }
        
    }

    @Override
    public int sizeInBytes() {

        int mySize = 0;
        HashSet<Term> terms = new HashSet<>();
        for(String k: myMap.keySet()){
            mySize += BYTES_PER_CHAR*k.length();
            terms.addAll(myMap.get(k));

        }
        for(Term term: terms){
            mySize+= BYTES_PER_CHAR * term.getWord().length()+BYTES_PER_DOUBLE;
            
        }

        return mySize;
    }  
}

