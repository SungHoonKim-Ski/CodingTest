import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int maxLevel;
    static int total;
    static int[] intArr;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maxLevel = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        intArr = new int[maxLevel];
        for(int i=0; i<maxLevel; i++){
            intArr[i] = Integer.parseInt(st.nextToken());
            total += intArr[i];
        }
        if(DFS(0, 0)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static boolean DFS(int level, int sum){
        if(level == maxLevel){
            if(sum == (total - sum)){
                return true;
            }else{
                return false;
            }
        }else{
            if(DFS(level+1, sum + intArr[level])){
                return true;
            }else{
                if(DFS(level+1, sum)){
                    return true;
                }
                return false;
            }
        }
    }
}