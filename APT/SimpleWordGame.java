import java.util.Arrays;
import java.util.HashSet;

public class SimpleWordGame {
    public int points(String[] player, String[] dictionary) {
        
        int count = 0;
        HashSet<String> newset = new HashSet<>(Arrays.asList(player));
        for(String a: newset){
            for(String b: dictionary){
                if (b.equals(a))
                count+= b.length()*b.length();
            }

        }
        return count;
    }
}