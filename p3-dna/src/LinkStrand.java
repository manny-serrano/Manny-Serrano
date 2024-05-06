// @author Emmanuel Serrano Campa

public class LinkStrand implements IDnaStrand{

    public class Node{
        String info;
        Node next;
        
        public Node(String info){
        this.info = info;
        this.next = null;
        }
       }
       private Node myFirst, myLast;
       private long mySize;
       private int myAppends;
       private int myIndex;
       private Node myCurrent;
       private int myLocalIndex;

       public LinkStrand(){
            this("");
        }

        public LinkStrand(String source){
            initialize(source);
        }

    @Override
    public long size() {
        // TODO Auto-generated method stub
        return mySize;
        
    }

    @Override
    public void initialize(String source) {
        // TODO Auto-generated method stub
       
        myFirst = new Node(source);
        myLast = myFirst;
        myAppends =0;
        mySize = source.length();
       
    }

    @Override
    public IDnaStrand getInstance(String source) {
        // TODO Auto-generated method stub
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        // TODO Auto-generated method stub
        myLast.next = new Node(dna);
        myLast = myLast.next;
        mySize += myLast.info.length();
        myAppends ++;
        System.out.print(dna);
        return this;
      
    }
    @Override
    public String toString() {
        if(myFirst == null){
        return "";
        }

        StringBuilder n = new StringBuilder(myFirst.info);
        Node temp = myFirst.next;
        while(temp!= null){
            n.append(temp.info);
            temp = temp.next;
        }
            return n.toString();
            }

    @Override
    public IDnaStrand reverse() {
        // TODO Auto-generated method stub
        Node curr = myFirst;
        LinkStrand r = new LinkStrand();
            while(curr != null){
        Node n = new Node(new StringBuilder(curr.info).reverse().toString());
        n.next = r.myFirst;
        r.myFirst = n;
        r.mySize += n.info.length();
        curr = curr.next;
        }
        return r;
       
    }

    @Override
    public int getAppendCount() {
        // TODO Auto-generated method stub
        return this.myAppends;
       
    }

    @Override
    public char charAt(int index) {
        // TODO Auto-generated method stub
        if (index < 0 || index >= mySize){
            throw new IndexOutOfBoundsException();

            }
            
            
        if(myIndex >= index || myCurrent == null){
            myIndex = 0;
            myLocalIndex =0;
            myCurrent = myFirst;
            
        }
        while(index!= myIndex){
            myIndex++;
            myLocalIndex++;
          if(myCurrent.next != null && myCurrent.info.length() <= myLocalIndex){
                myCurrent = myCurrent.next;
                myLocalIndex =0;
           }
        }
    char ret = myCurrent.info.charAt(myLocalIndex);
    return ret;
}
       
}


