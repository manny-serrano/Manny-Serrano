public class List2Long {
    public long convert(ListNode list) {
    long x = 0;
    int counter = 10;
        while(list != null) {
    x = x * counter + list.info; 
    list = list.next; 
    }
    return x; 
}
}