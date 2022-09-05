import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static BufferedReader br;
    private static StringBuffer sb;

    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        String[] inputSplit = br.readLine().split(" ");
        int countElement = Integer.parseInt(inputSplit[0]);

        int[] prefixArr = new int[4001];
        int[] negPrefixArr = new int[4001];

        int maxVal = -4001;
        int minVal = 4001;

        int sum = 0;

        for(int i=0; i<countElement; i++){

            int tmp = Integer.parseInt(br.readLine());
            if(maxVal < tmp){
                maxVal = tmp;
            }
            if(minVal > tmp){
                minVal = tmp;
            }
            if(tmp < 0){
                negPrefixArr[-tmp]++;
            }else{
                prefixArr[tmp]++;
            }
            sum += tmp;
        }

        sb.append((int)Math.round(sum / (double)countElement));
        sb.append("\n");
        sb.append(calMedian(prefixArr, negPrefixArr, countElement));
        sb.append("\n");
        sb.append(calMode(prefixArr, negPrefixArr));
        sb.append("\n");
        sb.append((maxVal != minVal) ? maxVal - minVal : 0);

        System.out.println(sb);

        br.close();
        sb.setLength(0);
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
}