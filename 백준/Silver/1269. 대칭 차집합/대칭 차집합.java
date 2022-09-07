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

        int setACount = Integer.parseInt(inputSplit[0]);
        int setBCount = Integer.parseInt(inputSplit[1]);

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        inputSplit = br.readLine().split(" ");

        for(int i=0; i<setACount; i++){
            setA.add(Integer.parseInt(inputSplit[i]));
        }

        int count = 0;
        inputSplit = br.readLine().split(" ");
        for(int i=0; i<setBCount; i++){
            int input = Integer.parseInt(inputSplit[i]);
            setB.add(input);
            if(setA.contains(input))
                count++;
        }
        int setAMinSetB = setACount - count;

        count = 0;
        for(Integer setAValue : setA){
            if(setB.contains(setAValue))
                count++;
        }

        int setBMinSetA = setBCount - count;

        System.out.println(setAMinSetB + setBMinSetA);
        br.close();
        sb.setLength(0);
    }

}