import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

//    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int size;
    private static Time[] times;

    public static void main(String args[]) throws IOException {

        size = Integer.parseInt(br.readLine());
        times = new Time[size];

        for(int i=0; i<size; i++){
            String[] input = br.readLine().split(" ");
            times[i] = new Time(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        Arrays.sort(times);

        int currentEndTime = 0;
        int count = 0;
        for(int i=0; i<size; i++){
            if(times[i].start >= currentEndTime){
                currentEndTime = times[i].end;
                count++;
            }
        }
        System.out.println(count);
        return;
    }

    private static class Time implements Comparable<Time>{

        int start, end;
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.end == o.end){
                return this.start - o.start;
            }else{
                return this.end - o.end;
            }
//            return this.end == o.end ? this.start - o.start : this.end - o.end;
        }
    }
}