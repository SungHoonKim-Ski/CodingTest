import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int distance = -Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        int count = 0;

        if(distance < 0){
            count = -distance;
        }else{
            count += distance / 5;
            distance -= count * 5;

            switch (distance){
                case 0:
                    break;
                case 1:
                    count++;
                    break;
                case 2:
                case 4:
                    count+= 2 ;
                    break;
                case 3:
                    count += 3;
            }
        }
        System.out.println(count);
    }
}