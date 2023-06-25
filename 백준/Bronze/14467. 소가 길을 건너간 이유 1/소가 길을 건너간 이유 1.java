import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int N;


    public static void input() throws Exception
    {

        N = Integer.parseInt(br.readLine());
    }

    static void pro() throws Exception
    {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, loc);
            } else {
                if (loc != hashMap.get(num)) {
                    cnt++;
                    hashMap.replace(num, loc);
                }
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}