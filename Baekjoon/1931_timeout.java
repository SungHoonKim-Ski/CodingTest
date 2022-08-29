import java.util.*;

public class Main {

    public static void main(String args[]){

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

//        List<Integer> startTimeList = new ArrayList<>();
//        List<Integer> endTimeList = new ArrayList<>();

        HashMap<Integer, Integer> inputMap = new HashMap<>(); //endTime, max startTime pair
        List<Integer> startTimeList = new ArrayList<>();

        for(int i=0; i<size; i++){
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();

            if(!inputMap.containsKey(startTime)){
                inputMap.put(startTime, endTime);
                startTimeList.add(startTime);
            }else{
                if(inputMap.get(startTime) > endTime) {
                    inputMap.replace(startTime, endTime);
                }
            }
        }

        int count = 0;
        int currentEndTime = 0;
        Collections.sort(startTimeList);

        while (startTimeList.size() > 0){
            int minEndTime = 100001; // value
            int minEndTimeKey = 0; // key > startTime
            for(int i=0; i<inputMap.size(); i++){
                int endTime = inputMap.get(startTimeList.get(i));
                if(endTime < minEndTime){
                    minEndTime = endTime;
                    minEndTimeKey = startTimeList.get(i);
                }
            }

            Stack<Integer> removeStack = new Stack<>();
            removeStack.push(minEndTimeKey);

            if(currentEndTime <= minEndTimeKey){
                count++;
                currentEndTime = minEndTime;

                for(int i=0; i<startTimeList.size(); i++){
                    if(startTimeList.get(i) < currentEndTime){
                        removeStack.push(startTimeList.get(i));
                    }
                }
            }

            while(removeStack.size() > 0) {
                Object removeStartTime = removeStack.pop();
                startTimeList.remove(removeStartTime);
                inputMap.remove(removeStartTime);
            }
        }

        System.out.println(count);
        return;
    }
}