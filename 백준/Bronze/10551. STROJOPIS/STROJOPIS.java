import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static char[] str;

    static void input() throws IOException{
        str = br.readLine().toCharArray();
    }

    static void pro() {
        String[] strs = new String[] {"1QAZ", "2WSX", "3EDC", "45RTFGVB", "67YUHJNM", "8IK,", "9OL.", "0-=P[];'/"};
        int[] nums = new int[300];
        for (int i = 0; i < strs.length; i++) {
            char[] x = strs[i].toCharArray();
            for (char c : x) {
                nums[c] = i;
            }
        }

        int[] res = new int[8];
        for (char c : str) {
            res[nums[c]]++;
        }
        
        for (int i : res) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}