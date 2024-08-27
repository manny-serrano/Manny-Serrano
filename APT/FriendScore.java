import java.util.HashMap;
import java.util.HashSet;

public class FriendScore {
    public int highestScore(String[] friends) {
        HashMap<Integer, HashSet<Integer>> mymap = new HashMap<>(); 
        
        int count  = 0; 
        for(int i =0; i<friends.length; i++){
            for(int j=0; j<friends[i].length(); j++){
                
                if(!mymap.containsKey(i)){
                    mymap.put(i, new HashSet<Integer> ()); 
                    mymap.get(i).add(j);
                }
                if(friends[i]){
                    mymap.put(i, new HashSet<Integer> ()); 
                    mymap.get(i).add(j);
                }

            }
           
        }
    }
}
