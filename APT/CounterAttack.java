import java.util.ArrayList;

public class CounterAttack {
    public int[] analyze(String str, String[] words) {
       String[] a = str.split(" ");

        ArrayList<Integer> counts = new ArrayList<Integer>();

       for (String  b: words ){
        int count =0;
            for ( String c : a){
                if (b.equals(c)){
                    count+=1;
                    
            }
            
       }
       counts.add(count);
    }

    int[] countedwords = new int[counts.size()];
        for (int x = 0; x < counts.size(); x++) {
            countedwords[x] = counts.get(x);
        }

        return countedwords;
}
}