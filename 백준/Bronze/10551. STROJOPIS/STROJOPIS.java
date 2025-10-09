import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static HashMap<Character, Integer> map;
    static char[] str;

    static void input() throws IOException{
        str = br.readLine().toCharArray();
    }

    static void pro() {
        map = new HashMap<>();

        map.put('1', 0);
        map.put('Q', 0);
        map.put('A', 0);
        map.put('Z', 0);

        map.put('2', 1);
        map.put('W', 1);
        map.put('S', 1);
        map.put('X', 1);

        map.put('3', 2);
        map.put('E', 2);
        map.put('D', 2);
        map.put('C', 2);

        map.put('4', 3);
        map.put('R', 3);
        map.put('F', 3);
        map.put('V', 3);
        map.put('5', 3);
        map.put('T', 3);
        map.put('G', 3);
        map.put('B', 3);

        map.put('6', 4);
        map.put('7', 4);
        map.put('Y', 4);
        map.put('U', 4);
        map.put('H', 4);
        map.put('J', 4);
        map.put('N', 4);
        map.put('M', 4);

        map.put('8', 5);
        map.put('I', 5);
        map.put('K', 5);
        map.put(',', 5);

        map.put('9', 6);
        map.put('O', 6);
        map.put('L', 6);
        map.put('.', 6);

        map.put('0', 7);
        map.put('-', 7);
        map.put('=', 7);
        map.put('P', 7);
        map.put('[', 7);
        map.put(']', 7);
        map.put(';', 7);
        map.put('\'', 7);
        map.put('/', 7);

        int[] res = new int[8];
        for (char c : str) {
            res[map.get(c)]++;
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