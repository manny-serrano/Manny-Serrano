import java.util.ArrayList;
import java.util.List;

public class SandwichBar {
    public int whichOrder(String[] available, String[] orders){
       for(int x=0; x<orders.length; x++){
        if(canmake(available, orders[x])){
            return x;
        }
        
       }
       return -1;

    }


    public boolean canmake(String[] available, String want){
        String[] ingredients = want.split("\\s+");
        List<String> Sandwich = new ArrayList<> ();
        for(String a: ingredients){
            Sandwich.add(a);
        }
        for(String b: Sandwich){
            boolean foundIngredient = false;
            for(String c: available){
                if(b.equals(c)){
                    foundIngredient = true;
                    break;

                }
                
            }
            if(!foundIngredient){
                return false;
            }

        }
        return true;
         
        
    }
}


      
