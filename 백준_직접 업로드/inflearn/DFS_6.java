import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] combinationArr;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        combinationArr = new int[y+1][x+1];
        for(int i=0; i<=y; i++){
            for(int j=0; j<=x; j++){
                if(i == 0 || j == 0 || i == j){
                    combinationArr[i][j] = 1;
                }
            }
        }
        System.out.println(DFS(y, x));
    }

    public static int DFS(int y, int x){
        if(combinationArr[y][x] == 0){
            combinationArr[y][x] = DFS(y-1, x-1) + DFS(y-1, x);
        }
        return combinationArr[y][x];
    }
}