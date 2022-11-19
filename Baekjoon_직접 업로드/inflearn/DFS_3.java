import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int maxWeight;
    static int dogsCount;
    static int maxDogsWeightSum = 0;
    static int[] intArr;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        maxWeight = Integer.parseInt(st.nextToken());
        dogsCount = Integer.parseInt(st.nextToken());
        intArr = new int[dogsCount];
        for(int i=0; i<dogsCount; i++){
            intArr[i] = Integer.parseInt(br.readLine());
        }
        DFS(0, 0);
        System.out.println(maxDogsWeightSum);
    }

    public static void DFS(int level, int sum){
        if(level == dogsCount){
            if(sum <= maxWeight){
                maxDogsWeightSum = sum > maxDogsWeightSum ? sum : maxDogsWeightSum;
            }
        }else{
            DFS(level+1, sum);
            DFS(level+1, sum + intArr[level]);
        }
    }
}