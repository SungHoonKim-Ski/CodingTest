import java.util.*;
import java.io.*;


public class Main
{


    static StringTokenizer st;
    static StringBuffer sb = new StringBuffer();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] inputChar;
    static char[] Happy = {':','-',')'};
    static char[] Sad = {':','-','('};

    public static void input() throws Exception
    {
        inputChar = br.readLine().toCharArray();
    }

    static void pro()
    {
        int happyCnt = 0;
        int sadCnt = 0;
        for (int i = 0; i < inputChar.length - 3; i++) {

            boolean isHappy = true;
            boolean isSad = true;
            for (int j = 0; j < 3; j++) {
                if (Happy[j] != inputChar[i + j]) isHappy = false;
                if (Sad[j] != inputChar[i + j]) isSad = false;
            }
            if (isSad) sadCnt++;
            else if (isHappy) happyCnt++;
        }

        if (happyCnt == 0 && sadCnt == 0) sb.append("none");
        else if (happyCnt == sadCnt) sb.append("unsure");
        else if (happyCnt > sadCnt) sb.append("happy");
        else sb.append("sad");
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}
