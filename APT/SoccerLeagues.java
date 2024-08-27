public class SoccerLeagues {
    public int[] points(String[] matches) {
        int n = matches.length; 
        int[] points = new int[n]; 

        
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n; j++) {
                
                if (i == j) continue;

                char result = matches[i].charAt(j);
                switch (result) {
                    case 'W': 
                        points[i] += 3; 
                        break;
                    case 'D': 
                        points[i] += 1; 
                        points[j] += 1; 
                        break;
                    case 'L': 
                        points[j] += 3; 
                        break;
                }
            }
        }

        return points;
    }
}


 
 