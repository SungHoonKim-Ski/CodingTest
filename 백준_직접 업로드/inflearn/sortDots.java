import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Dot implements Comparable<Dot> {

        int x;
        int y;
        Dot(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Dot o) {
            if(this.x == o.x){
                return this.y - o.y;
            }else{
                return this.x - o.x;
            }
        }

        public void print(){
            System.out.println(this.x + " " + this.y);
        }
    }
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int count = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Dot[] dots = new Dot[count];
        for(int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dots[i] = new Dot(x, y);
        }

        Arrays.sort(dots);
        for(int i=0; i<count; i++){
            dots[i].print();
        }
    }
}