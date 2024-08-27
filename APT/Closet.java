import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Closet {
    public String anywhere(String[] list) {

        TreeSet<String> totalwords = new TreeSet <>();

        for(String a : list){
            ArrayList <String> list2 = new ArrayList <String> (Arrays.asList(a.split(" ")));
            for(String b : list2){
                totalwords.add(b);
            }

           

        }
        return  String.join(" ", totalwords);
    }
}