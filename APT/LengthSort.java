import java.util.Arrays;
import java.util.Comparator;

public class LengthSort {
    private class LengthSortComp implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            if( a.length() == b.length()){
                for(int i =0; i<a.length(); i++){
                    if(a.charAt(i) < b.charAt(i)){
                        return -1;
                    }
                    if(a.charAt(i) > b.charAt(i)){
                        return 1;
                    }
                }
            }   
            if(a.length()< b.length()){
                return -1; 
            } 
            if(a.length() > b.length()){
                return 1; 
            }        
            return a.compareTo(b);
        }
    }
    
    public String[] rearrange(String[] values){
        Arrays.sort(values, new LengthSortComp());
        return values;
    }
}

