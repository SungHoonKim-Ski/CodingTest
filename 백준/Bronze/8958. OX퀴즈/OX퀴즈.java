import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static char[] InputCharArr;

    static void input() throws IOException
    {
        InputCharArr = br.readLine().toCharArray();
    }

    static void pro() throws IOException
    {
        int sum = 0;
        int curNum = 0;
        for (int i = 0; i < InputCharArr.length; i++) {
        if (InputCharArr[i] == 'O') sum += ++curNum;
        else curNum = 0;
        }
        sb.append(sum).append('\n');
    }


    public static void main(String[] args) throws Exception{

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0){
            input();
            pro();
        }
        System.out.println(sb);
    }

}