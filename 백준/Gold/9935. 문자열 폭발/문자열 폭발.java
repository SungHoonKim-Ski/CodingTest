import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static char[] BombChar;
    static char[] InputCharArr;



    static void input() throws IOException
    {
        InputCharArr = br.readLine().toCharArray();
        BombChar = br.readLine().toCharArray();
    }

    static void pro()
    {

        bombString();

        if (sb.length() == 0) sb.append("FRULA");

        System.out.println(sb);
    }

    static void bombString() {

        for (int i = 0; i < InputCharArr.length; i++) {

            sb.append(InputCharArr[i]);
            if (sb.length() < BombChar.length) continue;
            if (InputCharArr[i] != BombChar[BombChar.length - 1]) continue;

            boolean isSame = true;
            for (int j = 0; j < BombChar.length; j++) {
                if(BombChar[j] != sb.charAt(sb.length() - BombChar.length + j)) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) sb.delete(sb.length() - BombChar.length, sb.length());
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();

    }

}