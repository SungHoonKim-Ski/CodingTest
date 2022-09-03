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
        HashMap<Integer, Integer> resMap = new HashMap<>();
        //<M, constructor> pair
        int m = 0;
        while (++m < 1000001){
            int decomposition = 0;
            int x = m;
            while (x >= 10){
                decomposition += (x%10);
                x/= 10;
            }
            decomposition += x;
            decomposition += m;

            if(!resMap.containsKey(decomposition)){
                resMap.put(decomposition, m);
            }
        }

        int input = Integer.parseInt(br.readLine());
        if(resMap.containsKey(input)){
            System.out.println(resMap.get(input));
        }else{
            System.out.println(0);
        }
    }

}