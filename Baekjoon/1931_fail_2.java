import java.util.*;

public class Main {

    public static void main(String args[]){

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

//        List<Integer> startTimeList = new ArrayList<>();
//        List<Integer> endTimeList = new ArrayList<>();

        HashMap<Integer, Integer> startEndMap = new HashMap<>(); //endTime, max startTime pair
        HashMap<Integer, Integer> endStartMap = new HashMap<>();
        List<Integer> endTimeList = new ArrayList<>();

        int maxStartTime = 0;
        int maxEndTime = 0;

        for(int i=0; i<size; i++){
            int startTime = sc.nextInt();
            if(startTime > maxStartTime){
                maxStartTime = startTime;
            }
            int endTime = sc.nextInt();
            if(endTime > maxEndTime){
                maxEndTime = endTime;
            }

            if(!startEndMap.containsKey(startTime)){
                startEndMap.put(startTime, endTime);
            }else{
                if(startEndMap.get(startTime) > endTime) { // 시작시간이 같은 경우 끝나는 시간이 더 작은 회의로 replace
                    startEndMap.replace(startTime, endTime);
                }
            }
        }
        for(Integer startTime : startEndMap.keySet()){
            int endTime = startEndMap.get(startTime);

            endTimeList.add(endTime);
            endStartMap.put(endTime, startTime);
        }

        Collections.sort(endTimeList);

        int currentEndTime = endTimeList.get(0);
        int currentStartTime = endStartMap.get(currentEndTime);
        int count = 1;

        int index = 1;
        // currentEndTime <= startTime && min(endTime) -> count++
        while(endTimeList.size() != index){
            int endTime = endTimeList.get(index);
            int startTime = endStartMap.get(endTime);
            if(currentEndTime <= startTime){
                currentEndTime = endTime;
                count++;

                System.out.println(startTime + " " + endTime);
            }
            index++;
        }

        System.out.println(count);
        return;
    }
}