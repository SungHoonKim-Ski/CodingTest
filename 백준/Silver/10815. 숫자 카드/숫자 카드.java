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
        HashSet<String> hashSet = new HashSet<>();
        for(int i=0; i< inputSplit.length; i++){
            hashSet.add(inputSplit[i]);
        }

        br.readLine();
        inputSplit = br.readLine().split(" ");
        for(int i=0; i< inputSplit.length; i++){
            if(hashSet.contains(inputSplit[i])){
                sb.append(1);
            }else{
                sb.append(0);
            }
            sb.append(" ");
        }


        sb.setLength(sb.length()-1);
        System.out.println(sb);
        br.close();
        sb.setLength(0);
    }

}