import java.util.ArrayList;

import java.util.List;

public class DNAMaxNucleotide {
    public String max(String[] strands, String nuc) {
        List<String> dna = new ArrayList<> ();
        for(String i : strands){
            if (i.contains(nuc)){
                dna.add(i);
            }
        }
        String word = "";
        int maxvalue=0;
        for(String c : dna){
            int occurence = Occurences(c, nuc);
            if (occurence> maxvalue){
                maxvalue=occurence;
                word =c;
                }
            if (occurence== maxvalue && c.length() > word.length())
            word = c;
            }
            return word;
        }
    private int Occurences(String strand, String nuc){
        char b = nuc.charAt(0);
        int count=0;
        for (int a = 0; a < strand.length(); a++) {
            if (strand.charAt(a) == b) {
                count++;
            }
        }
        return count;
    }
}