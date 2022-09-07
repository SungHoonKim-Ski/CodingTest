import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);
    static int[][] weightValueArr;
    static int maxWeight;
    static StringBuffer sb;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();


        String[] inputSplit = br.readLine().split(" ");
        int size = Integer.parseInt(inputSplit[0]);
        maxWeight = Integer.parseInt(inputSplit[1]);

        HashMap<Integer, Integer> weightValueMap = new HashMap<>();

        for(int i=0; i<size; i++){
            inputSplit = br.readLine().split(" ");
            int weight = Integer.parseInt(inputSplit[0]);
            int value = Integer.parseInt(inputSplit[1]);

            if(!weightValueMap.containsKey(weight)){
                weightValueMap.put(weight,value);
            }else{
                if(value > weightValueMap.get(weight)){
                    weightValueMap.replace(weight, value);
                }
            }
        }

        weightValueArr = new int[size][2];
        int j=0;
        for(Integer weight : weightValueMap.keySet()){
            weightValueArr[j][0] = weight;
            weightValueArr[j][1] = weightValueMap.get(weight);
            j++;
        }

        int maxVal = 0;
        for(int i=size-1; i>=0; i--){
            int res = getMaxValueLessThanMaxWeight(i, 0, 0);
            sb.append("\n");
            if(res > maxVal){
                maxVal = res;
            }
        }


//        sb.setLength(sb.length()-1);
//        System.out.println(maxVal);
        System.out.println(sb);
        br.close();
//        sb.setLength(0);
    }

    public static int getMaxValueLessThanMaxWeight(int index, int prevWeight, int prevVal){
        sb.append(index + " ");
        int curWeight = prevWeight + weightValueArr[index][0];
        int curVal = prevVal + weightValueArr[index][1];
        if(maxWeight < curWeight){
            return prevVal;
        }
        if(maxWeight == curWeight || index ==0){
            return curVal;
        }

        for(int i=index-1; i>=0; i--){
            return getMaxValueLessThanMaxWeight(i, curWeight, curVal);
        }
        return 0;
    }
}