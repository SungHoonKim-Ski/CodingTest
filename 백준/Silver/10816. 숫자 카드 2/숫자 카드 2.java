import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        br.readLine();

        int[] card = new int[10000001];
        int[] _card = new int[10000001];
        String[] inputSplit = br.readLine().split(" ");

        for(int i=0; i< inputSplit.length; i++){
            int input = Integer.parseInt(inputSplit[i]);
            if(input < 0){
                _card[-input]++;
            }else{
                card[input]++;
            }
        }

        br.readLine();
        inputSplit = br.readLine().split(" ");
        for(int i=0; i< inputSplit.length; i++){
            int input = Integer.parseInt(inputSplit[i]);
            if(input < 0){
                sb.append(_card[-input]);
            }else{
                sb.append(card[input]);
            }
            sb.append(" ");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
        br.close();
        sb.setLength(0);
    }

}