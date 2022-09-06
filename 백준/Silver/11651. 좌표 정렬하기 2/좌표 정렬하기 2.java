import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br;
    private static StringBuffer sb;

    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        int size = Integer.parseInt(br.readLine());
        Point[] points = new Point[size];
        for(int i=0; i<size; i++){
            String[] inputSplit = br.readLine().split(" ");
            points[i] = new Point(Integer.parseInt(inputSplit[0]), Integer.parseInt(inputSplit[1]));
        }

        Arrays.sort(points);

        for(Point point : points){
            sb.append(point.print());
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);

        br.close();
        sb.setLength(0);
    }

    public static class Point implements Comparable<Point>{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public String print(){
            return (x + " " + y + "\n");
        }

        @Override
        public int compareTo(Point o) {
            if(y == o.y){
                return x - o.x;
            }else{
                return y - o.y;
            }
        }
    }

}