import java.util.*;


public class Main {

    public static void main(String args[]){

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MAX_VAL = 100001;
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[] startTimeArr = new int[size];
        int[] endTimeArr = new int[size];

        int minEndTime = MAX_VAL; // max+1
        int firstMinEndTimeIndex = MAX_VAL;

        for(int i=0; i<size; i++){
            startTimeArr[i] = sc.nextInt();

            int endTime = sc.nextInt();
            endTimeArr[i] = endTime;
            if(endTime < minEndTime){
                minEndTime = endTime;
                firstMinEndTimeIndex = i;
            }
        }

        int currentStartTime = startTimeArr[firstMinEndTimeIndex];
        int currentEndTime = endTimeArr[firstMinEndTimeIndex];

        startTimeArr[firstMinEndTimeIndex] = MAX_VAL;
        endTimeArr[firstMinEndTimeIndex] = MAX_VAL;

        int count = 1;
        int realSize = (size-1);

        while(realSize != 0){
            
            Stack<Integer> removeIndex = new Stack<>();
            minEndTime = MAX_VAL;
            int minStartTime = MAX_VAL;
            int minEndTimeIndex = MAX_VAL;

            for(int i=0; i<size; i++){
                if(endTimeArr[i] == MAX_VAL){
                    continue;
                }

                if(startTimeArr[i] >= currentEndTime){
                    if(minEndTime > endTimeArr[i]){
                        minEndTime = endTimeArr[i];
                        minStartTime = startTimeArr[i];
                        minEndTimeIndex = i;

                    }
                    if(minEndTime == endTimeArr[i] && minStartTime > startTimeArr[i]){
                        minStartTime = startTimeArr[i];
                        minEndTimeIndex = i;
                    }
                }else{// startTimeList.get(i) < currentEndTime
                    removeIndex.push(i);
                }
            }

            if(minEndTimeIndex != MAX_VAL){
                count++;
                currentEndTime = endTimeArr[minEndTimeIndex];
                removeIndex.push(minEndTimeIndex);
            }

            while(!removeIndex.isEmpty()){
                endTimeArr[removeIndex.pop()] = MAX_VAL;
                --realSize;
            }

        }
        System.out.println(count);
        return;

    }
}