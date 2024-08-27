import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BigSpender {
    public String spend(String[] toys, int[] prices, int budget) {
    List<String> boughttoyz = new ArrayList<>(); 
    List<String> toyz = new ArrayList<>(); 
    HashSet<String> unique = new HashSet<>();
          
    for(String a: toys){
        toyz.add(a);
    }

        for(int i=0; i<prices.length; i++){
            if( budget>= prices[i] && !unique.contains(toyz.get(i))){
                boughttoyz.add(toyz.get(i));
                unique.add(toyz.get(i));
                budget = budget -prices[i];
               
                
            }
        }  
    
        
    
    
    return String.join(" ", boughttoyz);
    }
}