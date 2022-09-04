import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br;
    private static StringBuffer sb;
    static char[][] inputArr;

    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        String[] inputNM = br.readLine().split(" ");
        int y = Integer.parseInt(inputNM[0]);
        int x = Integer.parseInt(inputNM[1]);

        inputArr = new char[y][x];
        for(int i=0; i<y; i++){
            inputArr[i] = br.readLine().toCharArray();
        }

        int minChangeVal = 65; // maxChangeVal
        for(int i=0; i < y-7; i++){
            for(int j=0; j<x-7; j++){
                int changeVal = getChangeVal(i, j);
                if(minChangeVal > changeVal){
                    minChangeVal = changeVal;
                }
            }
        }
        System.out.println(minChangeVal);
    }

    public static int getChangeVal(int y, int x){
        int changeValStartBlack = 0;
        boolean needBlack = true;
        for (int i=y; i<y+8; i++){
            for(int j=x; j<x+8; j++){
                if (needBlack && (inputArr[i][j] == 'W')){
                    changeValStartBlack++;
                }
                if(!needBlack && (inputArr[i][j] == 'B')){
                    changeValStartBlack++;
                }
                needBlack = !needBlack;
            }
            needBlack = !needBlack;
        }

        int changeValStartWhite = 0;
        needBlack = false;
        for (int i=y; i<y+8; i++){
            for(int j=x; j<x+8; j++){
                if (needBlack && (inputArr[i][j] == 'W')){
                    changeValStartWhite++;
                }
                if(!needBlack && (inputArr[i][j] == 'B')){
                    changeValStartWhite++;
                }
                needBlack = !needBlack;
            }
            needBlack = !needBlack;
        }
        return (changeValStartWhite > changeValStartBlack) ? changeValStartBlack : changeValStartWhite;
    }

}