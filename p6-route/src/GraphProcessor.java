import java.security.InvalidAlgorithmParameterException;
import java.io.*;
import java.util.*;


/**
 * Models a weighted graph of latitude-longitude points
 * and supports various distance and routing operations.
 * To do: Add your name(s) as additional authors
 * @author Brandon Fain
 * @author Owen Astrachan modified in Fall 2023
 *
 */
public class GraphProcessor {
    /**
     * Creates and initializes a graph from a source data
     * file in the .graph format. Should be called
     * before any other methods work.
     * @param file a FileInputStream of the .graph file
     * @throws Exception if file not found or error reading
     */

    // include instance variables here
    Map<Point, ArrayList <Point>> mymap; 
    List<Point> locations; 
    HashSet<Point> visited; 
    int vertices, edges; 


    public GraphProcessor(){
        mymap = new HashMap<>(); 
        locations = new ArrayList<>(); 
        visited = new HashSet<>();
        vertices = 0;
        edges =0; 



    }

    /**
     * Creates and initializes a graph from a source data
     * file in the .graph format. Should be called
     * before any other methods work.
     * @param file a FileInputStream of the .graph file
     * @throws IOException if file not found or error reading
     */

    public void initialize(FileInputStream file) throws IOException {
       Scanner scanner = new Scanner(file);
        vertices = scanner.nextInt();
        edges = scanner.nextInt();
        for(int i=0; i < vertices; i++){

            String name = scanner.next();
            double lat = scanner.nextDouble();
            double lon = scanner.nextDouble();
            locations.add(new Point(lat, lon)); 

        }

        scanner.nextLine(); 
        for(int i= 0; i< edges; i++)
        {
            String line = scanner.nextLine();
            String [] parsed = line.split(" ");

            int a = Integer.parseInt(parsed[0]);
            int b = Integer.parseInt(parsed[1]);
            String name =null; 

            if( parsed.length>2)
            {
                name=parsed[2];
            }
            mymap.putIfAbsent(locations.get(a), new ArrayList<>());
            mymap.putIfAbsent(locations.get(b), new ArrayList<>());
            mymap.get(locations.get(a)).add(locations.get(b));
            mymap.get(locations.get(b)).add(locations.get(a));








        }
        scanner.close();


    }

    /**
     * Searches for the point in the graph that is closest in
     * straight-line distance to the parameter point p
     * @param p is a point, not necessarily in the graph
     * @return The closest point in the graph to p
     */
    public Point nearestPoint(Point p) {

        double minDistance = Double.MAX_VALUE;
        Point answer = null; 
        
        for(Point b: locations){
            if(b.distance(p)< minDistance){
                answer = b; 
                minDistance = b.distance(p); 
            }
        }
        return answer;
    }

    /**
     * Calculates the total distance along the route, summing
     * the distance between the first and the second Points, 
     * the second and the third, ..., the second to last and
     * the last. Distance returned in miles.
     * @param start Beginning point. May or may not be in the graph.
     * @param end Destination point May or may not be in the graph.
     * @return The distance to get from start to end
     */
    public double routeDistance(List<Point> route) {
        double d = 0.0;
       for (int i =0; i<route.size() -1; i++){
            d+= route.get(i).distance(route.get(i+1)); 

       }
        return d;
    }
    

    /**
     * Checks if input points are part of a connected component
     * in the graph, that is, can one get from one to the other
     * only traversing edges in the graph
     * @param p1 one point
     * @param p2 another point
     * @return true if and onlyu if p2 is reachable from p1 (and vice versa)
     */
    public boolean connected(Point p1, Point p2) {
    

        if(!mymap.containsKey(p1)|| !mymap.containsKey(p2)){
                return false; 
        }

        visited.clear();

        Queue<Point> checkp = new LinkedList<>();
        checkp.add(p1);

        while(checkp.size()>0){
            Point current = checkp.remove();
            visited.add(current);
            for(Point a: mymap.get(current)){

                if(!visited.contains(a)){


                    checkp.add(a); 
                }
            }



        }

        return visited.contains(p2);
    }

    /**
     * Returns the shortest path, traversing the graph, that begins at start
     * and terminates at end, including start and end as the first and last
     * points in the returned list. If there is no such route, either because
     * start is not connected to end or because start equals end, throws an
     * exception.
     * @param start Beginning point.
     * @param end Destination point.
     * @return The shortest path [start, ..., end].
     * @throws IllegalArgumentException if there is no such route, 
     * either because start is not connected to end or because start equals end.
     */
    public List<Point> route(Point start, Point end) throws IllegalArgumentException {
        if(start.equals(end)){

            throw new IllegalArgumentException("No path between start and end"); 
        }
        visited.clear();
        Map<Point, Double> distancemap = new HashMap<>();
        Map<Point, Point> redo = new HashMap<>();
        redo.put(start, null);

        final Comparator<Point> comp = new Comparator<Point>(){
            @Override 
            public int compare(Point a, Point b){

                return distancemap.get(a).compareTo(distancemap.get(b));
            }


        }; 

        for (Point x: locations)
        {

            distancemap.put(x, Double.POSITIVE_INFINITY); 
        }

        PriorityQueue<Point> heapq = new PriorityQueue<>(comp);
        Point curr = start; 
        distancemap.put(start, 0.);
        heapq.add(curr);

        while(heapq.size()>0){

            curr = heapq.remove();
            if(curr.equals(end)){
                break;
            }

            for(Point y: mymap.get(curr)){

                double weight = curr.distance(y);
                double newdistance = distancemap.get(curr)+ weight; 
                if(newdistance< distancemap.get(y)){

                    distancemap.put(y, newdistance); 
                    redo.put(y, curr); 
                    heapq.add(y); 

                }
            }
        }


        if(!curr.equals(end)){

            throw new IllegalArgumentException("No path between start and end"); 
        }

        List<Point> bruh = new ArrayList<>();

        while(curr !=null){

            bruh.add(curr);
            curr = redo.get(curr);

        }

        Collections.reverse(bruh);
        return bruh;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String name = "data/usa.graph";
        GraphProcessor gp = new GraphProcessor();
        gp.initialize(new FileInputStream(name));
        System.out.println("running GraphProcessor");
    }


    
}
