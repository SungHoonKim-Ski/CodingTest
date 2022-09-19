import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String[] inputSplit = br.readLine().split(" ");
        int n = Integer.parseInt(inputSplit[0]);
        int m = Integer.parseInt(inputSplit[1]);

        int[] arr = new int[n];
        int[] sumArr = new int[n];

        inputSplit = br.readLine().split(" ");
        arr[0] = Integer.parseInt(inputSplit[0]);
        sumArr[0] = arr[0];

        for(int i=1; i<n; i++){
            arr[i] = Integer.parseInt(inputSplit[i]);
            sumArr[i] = arr[i] + sumArr[i-1];
        }

        for(int i=0; i<m; i++){
            inputSplit = br.readLine().split(" ");
            int from = Integer.parseInt(inputSplit[0]);
            int to = Integer.parseInt(inputSplit[1]);

            if(from == to){
                sb.append(arr[to - 1]);
            }else if (from == 1){
                sb.append(sumArr[to - 1]);
            }else{
                int res = sumArr[to - 1] - sumArr[from - 2];
                sb.append(res);
            }
            sb.append("\n");
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

}