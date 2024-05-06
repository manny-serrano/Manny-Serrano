public class Person201Closest {
    public static void main(String[] args) throws Exception {
        String file = "data/large.txt";
        double min = Double.MAX_VALUE;
        Person201 a = null;
        Person201 b = null;
        Person201[] people = Person201Utilities.readFile(file);
        for (Person201 person1: people){
            for(Person201 person2 : people ){
                if( person1 !=  person2){
                    double closestdist = person1.distanceFrom(person2);
                    if(closestdist < min){
                            min = closestdist;
                            a = person1;
                            b =person2; 
                    }
                }
            }
        }
        
        
        System.out.printf("closest distance is %3.2f between %s and %s\n",min,a.getName(),b.getName());
    }

}
