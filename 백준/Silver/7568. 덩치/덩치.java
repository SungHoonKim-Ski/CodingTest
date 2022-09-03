import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br;
    private static StringBuffer sb;
    private static int count;
    private static int[][] users;

    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        count = Integer.parseInt(br.readLine());
        users = new int[count][2]; // index, weight height

        String[] split;
        for(int i=0; i<count; i++){
            split = br.readLine().split(" ");
            users[i][0] = Integer.parseInt(split[0]);
            users[i][1] = Integer.parseInt(split[1]);
        }

        for (int i=0; i<count; i++){
            sb.append(compareAllUsers(i, users[i][0], users[i][1]) + " ");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    static private int compareAllUsers(int i, int curWeight, int curHeight){

        int rank = 1;
        for(int j=0; j<count; j++){
            if(i == j){
                continue;
            }
            int weight = users[j][0];
            int height = users[j][1];

            if(curWeight < weight && curHeight < height){
                rank++;
            }
        }

        return rank;
    }

}