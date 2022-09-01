import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

//    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br;
    private static StringBuffer sb;

    static int minTiredPerHour;
    static int workPerHour;
    static int plusTiredPerHour;
    static int maxTired;

    static int tired;
    static int time;
    static int work;
    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        plusTiredPerHour = Integer.parseInt(input[0]); // + tired/hour = A
        workPerHour = Integer.parseInt(input[1]); // + work/hour = B
        minTiredPerHour = Integer.parseInt(input[2]); // - tired/hour = C
        maxTired = Integer.parseInt(input[3]); // max tired = M



        while (time < 24){
            work();
            rest();
        }
        System.out.println(work);
    }

    private static void work(){
        while (tired < maxTired){
            if(time == 24){
                break;
            }
            if((tired + plusTiredPerHour) <= maxTired){
                tired += plusTiredPerHour;
                work += workPerHour;
                time++;
            }else{
                break;
            }
        }
    }
    private static void rest(){
        tired -= minTiredPerHour;
        time++;
        if(tired < 0){
            tired = 0;
        }
    }

}