import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] splitInput = input.split(" ");

        int x = Integer.parseInt(splitInput[1]);
        int y = Integer.parseInt(splitInput[0]);
        int resCount = Integer.parseInt(splitInput[2]);
        Queue<Integer> resQueue = new LinkedList<>();

        int[][] sumSquare = new int[y][x];
        for(int i=0; i<y; i++){
            input = br.readLine();
            splitInput = new String[x+1];
            splitInput = input.split(" ");
            for(int j=0; j<x; j++){
                int tmp = Integer.parseInt(splitInput[j]);
                if(j==0){
                    sumSquare[i][0] = tmp;
                }else{
                    sumSquare[i][j] = sumSquare[i][j-1] + tmp;
                }
            }
        }

        while(resCount-- > 0){

            input = br.readLine();
            splitInput = new String[5];
            splitInput = input.split(" ");

            int startPointX = Integer.parseInt(splitInput[1])-1;
            int startPointY = Integer.parseInt(splitInput[0])-1;
            int endPointX = Integer.parseInt(splitInput[3])-1;
            int endPointY = Integer.parseInt(splitInput[2])-1;

            int avg = 0;
            int avgCount = (endPointX - startPointX + 1) * (endPointY - startPointY + 1);
            for(int i=startPointY; i<=endPointY; i++){
                if(startPointX == 0){
                    avg += sumSquare[i][endPointX];
                }else{
                    avg += (sumSquare[i][endPointX] - sumSquare[i][startPointX-1]);
                }
            }

            avg /= avgCount;
            resQueue.add(avg);
        }

        while(!resQueue.isEmpty()){
            System.out.println(resQueue.poll());
        }
        return;
    }
}

