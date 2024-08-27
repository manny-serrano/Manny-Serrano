import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MemberCheck {
    public String[] whosDishonest(String[] club1, 
                                  String[] club2, 
                                  String[] club3) {
           TreeSet<String> names = new TreeSet<>();

           List<String> club1list = Arrays.asList(club1);
           List<String> club2list = Arrays.asList(club2);
           List<String> club3list = Arrays.asList(club3);

           for(String b : club1list){
            if(club2list.contains(b) || club3list.contains(b)){
                names.add(b);
            }
        }
            for(String a : club2list){
                if(club1list.contains(a) || club3list.contains(a)){
                    names.add(a);
                }
           }
           String dishonest[] = new String[names.size()]; 
        
         names.toArray(dishonest);

           return dishonest; 
    }
 }