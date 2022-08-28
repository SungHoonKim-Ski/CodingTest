import java.util.*;

public class Main {

    public static void main(String args[]){

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

//        List<Integer> startTimeList = new ArrayList<>();
//        List<Integer> endTimeList = new ArrayList<>();

        HashMap<Integer, Integer> inputMap = new HashMap<>(); //endTime, max startTime pair
        List<Integer> endTimeList = new ArrayList<>();

        for(int i=0; i<size; i++){
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();

            if(!inputMap.containsKey(endTime)){
                inputMap.put(endTime, startTime);
                endTimeList.add(endTime);
            }else{
                if(inputMap.get(endTime) > startTime) {
                    inputMap.replace(endTime, startTime);
                }
            }
        }

        int count = 0;
        int currentEndTime = 0;
        Collections.sort(endTimeList);

        while (endTimeList.size() > 0){
            int endTime = endTimeList.get(0);
            int startTime = inputMap.get(endTime);
            if(startTime >=currentEndTime){
                System.out.println(startTime + " " + endTime);
                currentEndTime = endTime;
                count++;
            }
            endTimeList.remove(0);
        }

        System.out.println(count);
        return;
    }
}