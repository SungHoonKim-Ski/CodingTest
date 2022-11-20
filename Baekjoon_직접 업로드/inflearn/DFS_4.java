import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int maxTime;
    static int scoreCount;
    static int maxScore = 0;
    static int[] scoreArr;
    static int[] timeArr;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        scoreCount = Integer.parseInt(st.nextToken());
        maxTime = Integer.parseInt(st.nextToken());
        scoreArr = new int[scoreCount];
        timeArr = new int[scoreCount];

        for(int i=0; i<scoreCount; i++){
            st = new StringTokenizer(br.readLine(), " ");
            scoreArr[i] = Integer.parseInt(st.nextToken());
            timeArr[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0, 0, 0);
        System.out.println(maxScore);
    }

    public static void DFS(int level, int sumTime, int sumScore){
        if(sumTime <= maxTime){
            if(level == scoreCount){
                maxScore = Math.max(maxScore, sumScore);
            }else{
                DFS(level+1, sumTime, sumScore);
                DFS(level+1, sumTime + timeArr[level], sumScore + scoreArr[level]);
            }
        }
    }
}