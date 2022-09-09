import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);
    static int[][][] dpArr;
    static StringBuffer sb;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        dpArr = new int[21][21][21];
        dpArr[0][0][0] = 1;

        for(int i=0; i<=20; i++){
            for(int j=0; j<=20; j++){
                for(int k=0; k<=20; k++){
                    dpArr[i][j][k] = w(i,j,k);
                }
            }
        }

        String input;
        while(true){
            input = br.readLine();
            if(input.equals("-1 -1 -1")){
                break;
            }
            String[] inputSplit =  input.split(" ");
            int a = Integer.parseInt(inputSplit[0]);
            int b = Integer.parseInt(inputSplit[1]);
            int c = Integer.parseInt(inputSplit[2]);

            print(a,b,c);
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    public static int w(int a, int b, int c){
        if(a == 0 || b == 0 || c == 0)
            return 1;
        else if(a > 20 || b > 20 || c > 20)
            return dpArr[20][20][20];
        else if (a < b && b < c)
            return dpArr[a][b][c-1] + dpArr[a][b-1][c-1]- dpArr[a][b-1][c];
        else
            return dpArr[a-1][b][c] + dpArr[a-1][b-1][c] + dpArr[a-1][b][c-1] - dpArr[a-1][b-1][c-1];

    }

    public static void print(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0){
            sb.append(String.format("w(%d, %d, %d) = %d", a, b, c, 1));
        }else if(a > 20 || b > 20 || c > 20){
            sb.append(String.format("w(%d, %d, %d) = %d", a, b, c, dpArr[20][20][20]));
        }else{
            sb.append(String.format("w(%d, %d, %d) = %d", a, b, c, dpArr[a][b][c]));
        }
    }
}