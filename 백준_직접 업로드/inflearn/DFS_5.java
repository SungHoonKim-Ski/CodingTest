import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int coinCount;
    static int minCoinCount = Integer.MAX_VALUE;
    static int coinSum;
    static int[] coinsArr;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        coinCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        coinsArr = new int[coinCount];
        for(int i=0; i<coinCount; i++){
            coinsArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coinsArr);
        coinSum = Integer.parseInt(br.readLine());

        DFS(0, 0);
        System.out.println(minCoinCount);
    }

    public static void DFS(int useCoinCount, int sumCoins){
        if(sumCoins == coinSum){
            minCoinCount = Math.min(minCoinCount, useCoinCount);
        }else if(minCoinCount > (useCoinCount + 1)){
            for(int i=coinCount-1; i >= 0; i--){
                if(sumCoins + coinsArr[i] <= coinSum){
                    DFS(useCoinCount + 1, sumCoins + coinsArr[i]);
                }
            }
        }
    }
}