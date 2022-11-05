import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] splitInput = input.split(" ");

        int[] timeArr = new int[3]; // 0:S, 1:E, 2:Q

        for(int i=0; i<3; i++){
            String[] tmp = splitInput[i].split(":");
            timeArr[i] = Integer.parseInt(tmp[0] + tmp[1]);
        }

        HashSet<String> chatBeforeStartSet = new HashSet<>();
        int checkedUser = 0;

        while((input = br.readLine()) != null){
            splitInput = input.split(" ");
            String[] tmp = splitInput[0].split(":");

            int chatTime = Integer.parseInt(tmp[0] + tmp[1]);
            String chatID = splitInput[1];  // splitInput[1] = id

            if(!(chatTime > timeArr[0])){ // chatTime <= S
                chatBeforeStartSet.add(chatID);
            }else if(!(chatTime < timeArr[1] || chatTime > timeArr[2])){
                if(chatBeforeStartSet.size() == 0){
                    break;
                }
                if(chatBeforeStartSet.contains(chatID)){
                        checkedUser++;
                        chatBeforeStartSet.remove(chatID);
                }
            }
        }
        System.out.println(checkedUser);
        return;
    }
}

