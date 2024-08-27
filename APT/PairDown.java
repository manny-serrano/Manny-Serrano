import java.util.ArrayList;

public class PairDown {
    public int[] fold(int[] list) {
       ArrayList<Integer> intarray = new ArrayList<>();
       
            if(list.length % 2 ==0){
                for(int i = 0; i<list.length; i+=2){
                int a = list[i] + list[i+1];
                intarray.add(a);
            }
           
       }
       else{
        for(int i=0; i<(list.length -1); i+=2){
            int a = list[i] + list[i+1];
                intarray.add(a);   
        }

        int a  = list[list.length -1] + 0;
        intarray.add(a);
       }

       int[] newlist = new int[intarray.size()];
       for (int i = 0; i < intarray.size(); i++) {
           newlist[i] = intarray.get(i);
       }
       return newlist;
    }
}
