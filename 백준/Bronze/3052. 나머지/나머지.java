import java.util.*;
import java.io.*;
import java.math.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int[] InputArr = new int[10];
    public static void input() throws IOException{
        for (int i = 0; i < 10; i++) InputArr[i] = Integer.parseInt(br.readLine());
    }

    public static void pro() {

        HashSet<Integer> modResSet = new HashSet<>();
        for (int i = 0; i < 10; i++) modResSet.add(InputArr[i] % 42);

        System.out.println(modResSet.size());

    }

    public static void main(String args[]) throws IOException
    {
        input();
        pro();

    }
}