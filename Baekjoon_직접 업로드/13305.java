import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()) - 1;// last city not required

        String[] split = br.readLine().split(" ");
        int[] betweenCityDis = new int[n];
        for(int i=0; i<n; i++){
            betweenCityDis[i] = Integer.parseInt(split[i]);
        }

        split = br.readLine().split(" ");
        int[] cityOilPrice = new int[n];
        for(int i=0; i<n; i++){
            cityOilPrice[i] = Integer.parseInt(split[i]);
        }

        int minOilPrice = cityOilPrice[0];
        long sumCost = (long)betweenCityDis[0] * cityOilPrice[0];

        for(int i=1; i<n; i++){
            if(minOilPrice > cityOilPrice[i]){
                minOilPrice = cityOilPrice[i];
            }
            sumCost += ((long)minOilPrice * betweenCityDis[i]);
        }

        System.out.println(sumCost);
        return;
    }
}