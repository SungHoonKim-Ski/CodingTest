import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCnt = (Integer.parseInt(br.readLine()));

        for(int i=0; i<caseCnt;i++){
            String[] stdInputArr = br.readLine().split(" ");

            int stdCnt = Integer.parseInt(stdInputArr[0]);
            int stdSum = 0;

            for(int j=1; j < stdCnt +1; j++){ // arr[0] = stdCnt
                stdSum += Integer.parseInt(stdInputArr[j]);
            }
            float stdAvg = stdSum / stdCnt;
            int moreThanAvgStdCnt = 0;
            for(int j=1; j<stdCnt +1; j++){
                if(stdAvg < Integer.parseInt(stdInputArr[j])){
                    moreThanAvgStdCnt += 1;
                }
            }
            System.out.println(String.format("%.3f", (float)moreThanAvgStdCnt / stdCnt * 100) + "%" );
        }

        return;
    }
}
