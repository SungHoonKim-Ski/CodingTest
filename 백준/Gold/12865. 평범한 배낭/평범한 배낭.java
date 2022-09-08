import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputSplit =  br.readLine().split(" ");
        int itemsCount = Integer.parseInt(inputSplit[0]);
        int maxWeight = Integer.parseInt(inputSplit[1]);

        int[][] backPack = new int[itemsCount+1][maxWeight+1];
        int[] weights = new int[itemsCount+1];
        int[] values = new int[itemsCount+1];

        for(int i=1;i<=itemsCount;i++) {
            inputSplit =  br.readLine().split(" ");
            weights[i] = Integer.parseInt(inputSplit[0]);
            values[i]= Integer.parseInt(inputSplit[1]);
        }

        for(int i=1;i<=itemsCount;i++) {
            for(int j=1;j<=maxWeight;j++) {
                backPack[i][j] = backPack[i-1][j];
                if(j - weights[i]>=0) {
                    backPack[i][j] = Math.max(backPack[i-1][j], backPack[i-1][j-weights[i]]+values[i]);
                }
            }
        }

        System.out.println(backPack[itemsCount][maxWeight]);
    }

}