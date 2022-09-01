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

        int input = Integer.MAX_VALUE;
        int contestCount = 0;

        while((input =Integer.parseInt(br.readLine())) != 0){
            HashMap<String, Integer[]> userMap = new HashMap();
            contestCount++;
            sb.append("CONTEST " + contestCount + "\n");
            for(int i=0; i<input; i++){
                String[] split = br.readLine().split(" ");
                String userName = split[0];
                Integer[] userData = new Integer[10];
                // userData[7] = cnt
                // userData[8] = sum
                // userData[9] = Geometric mean(기하평균)
                for(int j=1; j<8; j++){
                    int tmp = Integer.parseInt(split[j]);
                    if(tmp != 0){
                        userData[j-1] = tmp;
                        userData[7]++;
                        userData[8] += tmp;
                        userData[9] *= tmp;
                    }
                }

                for(int j=0; j<userData[7]; j++){
                    Math.sqrt(userData[9]);
                }

                userMap.put(userName, userData);
            }


        }

    }

}