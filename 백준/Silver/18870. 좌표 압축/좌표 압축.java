import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br;
    private static StringBuffer sb;

    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        int size = Integer.parseInt(br.readLine());

        int[] inputArr = new int[size];
        String[] inputSplit = br.readLine().split(" ");
        int minVal = Integer.MAX_VALUE;
        for(int i=0; i<size; i++){
            int input = Integer.parseInt(inputSplit[i]);
            if(minVal > input){
                minVal = input;
            }
            inputArr[i] = input;
        }

        int[] sortedInputArr = inputArr.clone();
        Arrays.sort(sortedInputArr);

        HashMap<Integer, Integer> compressInputMap = new HashMap<>();
        // realInput, compressInput  pair
        int i=0;
        int compressIndex = 0;
        while(i < sortedInputArr.length){
            if(!compressInputMap.containsKey(sortedInputArr[i])){
                compressInputMap.put(sortedInputArr[i], compressIndex);
                compressIndex++;
            }
            i++;
        }

        for(i=0; i<size; i++){
            sb.append(compressInputMap.get(inputArr[i]) + " ");
        }


        sb.setLength(sb.length()-1);
        System.out.println(sb);

        br.close();
        sb.setLength(0);
    }


}