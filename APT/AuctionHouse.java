import java.util.HashMap;

public class AuctionHouse {
    public int revenue(String[] bids, String filter) {
        HashMap<String, Integer> highest = new HashMap <>();
        for(String a: bids){
            String [] bidz = a.split(":");
            String element = bidz[0].trim();

            if(!highest.containsKey(element) || highest.get(element)< Integer.parseInt(bidz[1].trim())){
                highest.put(element, Integer.parseInt(bidz[1].trim()) );
            }
            
            
            
        }
        int total = 0;
        for(String b: filter.split("\\s+")){
            if(highest.containsKey(b)){
                total +=highest.get(b);
                
            }
       
        }
        return total;
        
    }
}
