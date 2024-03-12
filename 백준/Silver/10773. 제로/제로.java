import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int k;
    static void input() throws IOException{
        k = Integer.parseInt(br.readLine());
    }

    static void pro() throws IOException{

        Deque<Integer> stack = new ArrayDeque<>();
        while ( k-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) stack.pop();
            else stack.push(x);
        }
        int sum = 0;
        while (!stack.isEmpty()) sum += stack.poll();
        System.out.println(sum);
    }


    public static void main(String[] args) throws IOException {

        input();
        pro();
    }
}