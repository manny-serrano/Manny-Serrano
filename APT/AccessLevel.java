public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
       String m ="";
           for(int i : rights) {
              if(i<minPermission){
                     m+="D";
              }
              else {
                     m+="A";  
              }
              
           }
           return m;

    }
 }