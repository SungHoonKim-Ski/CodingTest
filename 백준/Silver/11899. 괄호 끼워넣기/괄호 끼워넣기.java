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

    static void pro()
    {
        int cnt = 0;
        int openCnt = 0;
        for (int i = 0; i < InputCharArr.length; i++) {
            if (InputCharArr[i] == '(') openCnt++;
            else {
                if (openCnt == 0) cnt++;
                else openCnt--;
            }
        }
        cnt += openCnt;
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();

    }

}