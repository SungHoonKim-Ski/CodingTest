import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static void pro() throws IOException {

        char[] str = br.readLine().toCharArray();
        HashMap<Character, String> hashMap = new HashMap<>();
        hashMap.put('0', "000");
        hashMap.put('1', "001");
        hashMap.put('2', "010");
        hashMap.put('3', "011");
        hashMap.put('4', "100");
        hashMap.put('5', "101");
        hashMap.put('6', "110");
        hashMap.put('7', "111");
        sb.append(hashMap.get(str[0]));
        if (sb.charAt(0) == '0') sb.delete(0, 1);
        if (sb.charAt(0) == '0') sb.delete(0, 1);
        if (sb.charAt(0) == '0') sb.delete(0, 1);
        for (int i = 1; i < str.length; i++) {
            sb.append(hashMap.get(str[i]));
        }
        if (sb.length() == 0) sb.append(0);
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException{
        pro();

    }

}
