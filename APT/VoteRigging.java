import java.util.*;
public class VoteRigging{
    public int minimumVotes(int[] votes ){
        int count = 0;
        if(votes.length == 1){
            return count;
        }
        int[] list1 = new int[votes.length-1];
        for(int j=0; j < list1.length; j++ ){
            list1[j] = votes[j+1];
        }
        Arrays.sort(list1);
        int max = list1[list1.length-1];

        while(votes[0] <= max){
            max--;
            list1[list1.length-1] = max;
            votes[0]++;
            count++;
            Arrays.sort(list1);
            max= list1[list1.length-1];
        }
        return count;
        
    }
   
}