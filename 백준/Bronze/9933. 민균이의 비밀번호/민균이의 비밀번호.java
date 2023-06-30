import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int N;
    static HashSet<String> hashSet;

    public static void input() throws Exception
    {
        N = Integer.parseInt(br.readLine());
        hashSet = new HashSet<>();
        while (N-- > 0) hashSet.add(br.readLine());
    }

    static void pro() throws Exception
    {

        int resCnt = 0;
        char midVal = ' ';
        for (String s : hashSet) {
            if (isPalindrome(s.toCharArray())) {
                resCnt = s.length();
                midVal = s.charAt(s.length()/ 2);
                break;
            }
            sb.setLength(0);
            sb.append(s);
            if (hashSet.contains(sb.reverse().toString())) {
                resCnt = s.length();
                midVal = s.charAt(s.length()/ 2);
                break;
            }
        }

        sb.setLength(0);
        sb.append(resCnt).append(' ').append(midVal);
        System.out.println(sb);
    }

    static boolean isPalindrome(char[] charArr) {
        for (int i = 0; i < charArr.length / 2; i++) {
            if (charArr[i] != charArr[charArr.length - 1 - i]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}
