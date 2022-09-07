import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String inputStr = br.readLine();
        HashSet<String> strSet = new HashSet<>();

        for(int i=0; i<inputStr.length(); i++){
            for(int j=i+1; j<=inputStr.length(); j++){
                strSet.add(inputStr.substring(i, j));
            }
        }

        System.out.println(strSet.size());

        br.close();
        sb.setLength(0);
    }

}