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
        String[] inputSplit = br.readLine().split(" ");
        HashMap<String, Integer> cardMap = new HashMap<>();
        for(int i=0; i< inputSplit.length; i++){
            if(!cardMap.containsKey(inputSplit[i])){
                cardMap.put(inputSplit[i], 1);
            }else{
                cardMap.replace(inputSplit[i], cardMap.get(inputSplit[i])+1);
            }
        }

        br.readLine();
        inputSplit = br.readLine().split(" ");
        for(int i=0; i< inputSplit.length; i++){
            if(cardMap.containsKey(inputSplit[i])){
                sb.append(cardMap.get(inputSplit[i]));

            }else{
                sb.append("0");
            }
            sb.append(" ");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
        br.close();
        sb.setLength(0);
    }

}