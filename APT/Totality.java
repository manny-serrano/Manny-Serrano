public class Totality {
    public int sum(int[] a, String stype) {
        int i=0;
        
        if(stype.equals("odd")){
            for(int x=0; x<a.length; x++){
                if(x % 2 == 1){
                    i+=a[x];
                }


            }
        }
        else if(stype.equals("even")){
            for(int x=0; x<a.length; x++){
                if(x % 2 == 0){
                    i+=a[x];
                }


            }
        }
        else {
            for(int x:a){
                i+=x;
            }
        }
        return i;    
    }
}
