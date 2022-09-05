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

        String[] inputSplit = br.readLine().split(" ");
        int countElement = Integer.parseInt(inputSplit[0]);
        int arithmeticMean = 0;

        int[] prefixArr = new int[4001];
        int[] negPrefixArr = new int[4001];

        for(int i=0; i<countElement; i++){
            int tmp = Integer.parseInt(br.readLine());

            if(tmp < 0){
                negPrefixArr[Math.abs(tmp)]++;
            }else{
                prefixArr[tmp]++;
            }

            arithmeticMean += tmp;
        }

        arithmeticMean = calArithmeticMean(arithmeticMean, countElement);
        int median = calMedian(prefixArr, negPrefixArr, countElement);
        int mode = calMode(prefixArr, negPrefixArr);
        int range = calRange(prefixArr, negPrefixArr);

        sb.append(arithmeticMean);
        sb.append("\n");
        sb.append(median);
        sb.append("\n");
        sb.append(mode);
        sb.append("\n");
        sb.append(range);

        System.out.println(sb);

        br.close();
        sb.setLength(0);

    }

    public static int calArithmeticMean(int sumElement, int countElement){

        return (int)Math.round(sumElement/(double)countElement);
    }

    public static int calMedian(int[] prefixArr, int[] negPrefixArr, int countElement){

        int medianIndex = countElement/2 + 1;
        for(int i=4000; i>=0; i--){
            if(negPrefixArr[i] > 0){
                medianIndex -= negPrefixArr[i];
            }
            if(medianIndex < 1){
                return -i;
            }
        }

        for(int i=0; i<4001; i++){
            if(prefixArr[i] > 0){
                medianIndex -= prefixArr[i];
            }
            if(medianIndex < 1){
                return i;
            }
        }

        return Integer.MAX_VALUE;
    }

    public static int calMode(int[] prefixArr, int[] negPrefixArr){

        int modeVal = 0;
        List<Integer> modeList = new ArrayList();

        for(int i=4000; i>=0; i--){
            if(modeVal < negPrefixArr[i]){
                modeVal = negPrefixArr[i];
                modeList.clear();
                modeList.add(-i);
            }else if(modeVal == negPrefixArr[i]){
                modeList.add(-i);
            }
        }

        for(int i=0; i<4001; i++){
            if(modeVal < prefixArr[i]){
                modeVal = prefixArr[i];
                modeList.clear();
                modeList.add(i);
            }else if(modeVal == prefixArr[i]){
                modeList.add(i);
            }
        }

        if(modeList.size() == 1){
            return modeList.get(0);
        }else{
            Collections.sort(modeList);
            return modeList.get(1);
        }

    }

    public static int calRange(int[] prefixArr, int[] negPrefixArr){

        int range = 0;
        boolean flag = false;
        for(int i=4000; i>=0; i--){
            if(negPrefixArr[i] > 0){
                range += i;
                flag = true;
                break;
            }
        }
        if(!flag){
            for(int i=0; i<4001; i++){
                if(prefixArr[i] > 0){
                    range -= i;
                    break;
                }
            }
        }

        flag = false;
        for(int i=4000; i>=0; i--){
            if(prefixArr[i] > 0){
                range += i;
                flag = true;
                break;
            }
        }

        if(!flag){
            for(int i=0; i<4001; i++){
                if(negPrefixArr[i] > 0){
                    range -= i;
                    break;
                }
            }
        }

        return range;
    }

}