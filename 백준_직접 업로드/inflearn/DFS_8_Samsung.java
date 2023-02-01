import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static class Point {
        int x;
        int y;
        Point(int y, int x){
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader br;
    static StringBuffer sb;

    static List<Point> houseList;
    static List<Point> pizzaHouseList;

    static int pizzaDeliverDistance = Integer.MAX_VALUE;

    static Point[] selectedPizzaPoints;
    static HashMap<Point, Integer> distanceMap;
    static int n, m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pizzaHouseList = new ArrayList<>();
        houseList = new LinkedList<>();
        distanceMap = new HashMap<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input == 1){
                    houseList.add(new Point(i, j));
                }else if(input == 2){
                    pizzaHouseList.add(new Point(i, j));
                }
            }
        }

        selectedPizzaPoints = new Point[m];
        DFS(0, 0);
        System.out.println(pizzaDeliverDistance);
    }

    public static void DFS(int level, int seq){
        if(level == m){
            initCalDistance();
            for(int i=0; i<m; i++){
                Point pizzaStore = selectedPizzaPoints[i];
                for(int j=0; j< houseList.size(); j++){
                    Point house = houseList.get(j);
                    int prevDis = distanceMap.get(house);
                    int distance = Math.abs(house.y - pizzaStore.y) + Math.abs(house.x - pizzaStore.x);
                    if(distance < prevDis){
                        distanceMap.replace(house, distance);
                    }
                }
            }

            int holeDistance = 0;
            for(int i=0; i< houseList.size(); i++){
                holeDistance += distanceMap.get(houseList.get(i));
            }
            pizzaDeliverDistance = Math.min(pizzaDeliverDistance, holeDistance);
            return;
        }
        for(int i=seq; i< pizzaHouseList.size(); i++){
            selectedPizzaPoints[level] = pizzaHouseList.get(i);
            DFS(level + 1, i + 1);
        }
    }

    static void initCalDistance(){
        for(int i=0; i< houseList.size(); i++){
            distanceMap.put(houseList.get(i), Integer.MAX_VALUE);
        }
    }
}