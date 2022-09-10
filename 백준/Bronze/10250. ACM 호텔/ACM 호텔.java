import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int count = Integer.parseInt(br.readLine());
        while (count > 0){
            String[] inputSplit =  br.readLine().split(" ");
            int height = Integer.parseInt(inputSplit[0]);
            int width = Integer.parseInt(inputSplit[1]);
            int guests = Integer.parseInt(inputSplit[2]);

            int curHeight = 0;
            int curWidth = 1;
            while(guests > 0){
                curHeight++;
                if(curHeight > height){
                    curWidth++;
                    curHeight = 1;
                }
                guests--;
            }

            sb.append(String.format("%d%02d\n", curHeight, curWidth));
            count--;
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);;
    }

}