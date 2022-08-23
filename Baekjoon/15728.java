import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> treeMap = new HashMap<>();

        String input = sc.nextLine();
        String[] splitInput = input.split(" ");

        int N = Integer.parseInt(splitInput[0]);
        int K = Integer.parseInt(splitInput[1]);

        input = sc.nextLine();
        splitInput = new String[N+1];
        splitInput = input.split(" ");


        int[] shareNum = new int[N];
        for(int i=0; i<N; i++){
            shareNum[i] = Integer.parseInt(splitInput[i]);
        }

        input = sc.nextLine();
        splitInput = input.split(" ");

        List<Integer> teamNumList = new ArrayList<>();
        for(int i=0; i<N; i++){
            teamNumList.add(Integer.parseInt(splitInput[i]));
        }

        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<K+1; i++){
            int currentMaxTeamNumIndex = 0;
            maxValue = Integer.MIN_VALUE;

            for(int j=0; j<teamNumList.size(); j++){
                int currentTeamNum = teamNumList.get(j);
                for(int q=0; q<N; q++){
                    int mul = currentTeamNum * shareNum[q];

                    if(maxValue < mul){
                        currentMaxTeamNumIndex = j;
                        maxValue = mul;
                    }
                }
            }
             teamNumList.remove(currentMaxTeamNumIndex);
        }
        System.out.print(maxValue);



        sc.close();
        return;
    }
}

