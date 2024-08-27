import java.util.HashMap;
import java.util.Map;

public class BigWord {
    public String most(String[] sentences) {
        Map<String, Integer>countmap = new HashMap<>();
        int counter =0;
        String bigword = "";
        for(String a : sentences){
            String [] sentence = a.split("\\s+");
            for(String b : sentence){
                    String c = b.toLowerCase();
                    countmap.put(c, countmap.getOrDefault(c, 0) + 1);
                        
              if(countmap.get(c)> counter){
                counter = countmap.get(c);
                bigword = c;
              }
            }
        }
        return bigword;
    }
}