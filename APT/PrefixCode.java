public class PrefixCode { 
    public String isOne(String[] words) {
        
        for (int i = 0; i < words.length; i++) {
            
            String currentWord = words[i];
            
            
            for (int j = 0; j < words.length; j++) {
                
                if (i != j) {
                   
                    if (words[j].startsWith(currentWord)) {
                        
                        return "No, " + i;
                    }
                }
            }
        }
        return "Yes";
    }
}
