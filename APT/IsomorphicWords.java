import java.util.HashMap;

public class IsomorphicWords {
    public int countPairs (String [] words){
        int counter =0;
        for(int a=0; a< words.length; a++){
            for(int i= a+1; i<words.length; i++){

                if(isomorphic(words[a], words[i]))
                    counter ++;
            }
        }
        return counter;

    }


    public boolean isomorphic (String first, String second){
            HashMap<Character, Character> map1 = new HashMap <>();
            HashMap<Character, Character> map2 = new HashMap <>();

            for (int x=0; x<first.length(); x++){
                   if(!map1.containsKey(first.charAt(x))){
                    map1.put(first.charAt(x), second.charAt(x));
                   }
                   if(!map2.containsKey(second.charAt(x))){
                    map2.put(second.charAt(x), first.charAt(x));
                   }

                   if(map1.containsKey(first.charAt(x))){

                    if(map1.get(first.charAt(x)) != second.charAt(x)){
                        return false;
                    }
                
                   }

                   if(map2.containsKey(second.charAt(x))){

                    if(map2.get(second.charAt(x)) != first.charAt(x)){
                        return false;
                    }
                
                   }

                   
                


            }
            return true;
    }
}
