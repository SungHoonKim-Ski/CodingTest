import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int N;


    static char[] CmdCharArr;
    static Deque<Integer> ACDeque;

    static void input() throws IOException
    {
        CmdCharArr = br.readLine().toCharArray();

        N = Integer.parseInt(br.readLine());
        ACDeque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");

        if (N == 0) return;
        if (st.countTokens() == 1) {
            String tmpStr = st.nextToken().replace("[", "");
            tmpStr = tmpStr.replace("]", "");
            ACDeque.add(Integer.parseInt(tmpStr));
        } else {
            ACDeque.add(Integer.parseInt(st.nextToken().replace("[","")));
            for (int i = 1; i < N - 1; i++) ACDeque.add(Integer.parseInt(st.nextToken()));
            ACDeque.add(Integer.parseInt(st.nextToken().replace("]","")));
        }
    }

    static void pro() throws IOException
    {
        boolean isReversed = false;
        for (int i = 0; i < CmdCharArr.length; i++) {
            if (CmdCharArr[i] == 'R') isReversed = !isReversed;
            else { // D
                if (ACDeque.isEmpty()) {
                    sb.append("error").append('\n');
                    return;
                }
                if (!isReversed) {
                    ACDeque.pollFirst();
                } else {
                    ACDeque.pollLast();
                }
            }
        }
        sb.append('[');
        if (!ACDeque.isEmpty()) {
            while (!ACDeque.isEmpty()) {
                if (!isReversed) sb.append(ACDeque.pollFirst()).append(',');
                else sb.append(ACDeque.pollLast()).append(',');
            }
            sb.setLength(sb.length() - 1);
        }
        sb.append(']').append('\n');

    }
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }

}