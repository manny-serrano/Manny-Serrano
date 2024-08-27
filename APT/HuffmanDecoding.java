import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class HuffmanDecoding {
    public String decode(String archive, String[] dictionary) {

        HashMap<String, Character> mymap = new HashMap<>();

        for (int i = 0; i < dictionary.length; i++) {
            mymap.put(dictionary[i], (char) (i + 65));
        }
        StringBuilder lol = new StringBuilder();
        char[] bit = archive.toCharArray();
        String current = "";

        for(int i = 0; i < bit.length; i++) {
            current += bit[i];

            if(mymap.containsKey(current)) {
                lol.append(mymap.get(current));
                current = "";
            }
        }

        return lol.toString();
    }
}