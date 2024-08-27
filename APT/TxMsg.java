public class TxMsg {
  public String getMessage(String original) {
    String[] newlist = original.split(" ");
    String acronym = "";

    for (String a: newlist){
      char [] b = a.toCharArray();
      
      if(isvowels(b) == true){
        acronym+= a;
    }
      for (int i = 0; i<b.length; i++){
       
         if (b.length==1 && "aeiou".indexOf(b[i]) == -1){
            
          acronym += b[i];
        }
       else if (i ==0 && "aeiou".indexOf(b[i]) == -1 ){
          acronym += b[i];
        }
        else if (i>0){
            if(("aeiou".indexOf(b[i]) == -1 && "aeiou".indexOf(b[i-1]) !=-1)){
              acronym += b[i];
             }
            
          }  
    }
    acronym += " ";
  }
  return acronym.toString().trim();
  }


  private boolean isvowels(char [] word){
    for( char a : word){
      if ("aeiou".indexOf(a) ==-1){
        return false;
      }
     
    }
    return true;
  }
}
