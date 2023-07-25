import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] DequeArr;


    static void input() throws IOException
    {
        N = Integer.parseInt(br.readLine());
        DequeArr = new int[N * 2];
    }

    static void pro() throws IOException
    {
        int front = N, back = N;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {

            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push_front": // front = DequeArr[--front]
                    DequeArr[--front] = Integer.parseInt(st.nextToken());
                    break;
                case "push_back": // back = DequeArr[back++]
                    DequeArr[back++] = Integer.parseInt(st.nextToken());
                    break;
                case "pop_front":
                    if (front == back) sb.append(-1);
                    else sb.append(DequeArr[front++]);
                    sb.append('\n');
                    break;
                case "pop_back":
                    if (front == back) sb.append(-1);
                    else sb.append(DequeArr[--back]);
                    sb.append('\n');
                    break;
                case "size":
                    sb.append(back - front).append('\n');
                    break;
                case "empty":
                    if (front == back) sb.append(1);
                    else sb.append(0);
                    sb.append('\n');
                    break;
                case "front":
                    if (front != back) sb.append(DequeArr[front]);
                    else sb.append(-1);
                    sb.append('\n');
                    break;
                case "back":
                    if (front != back) sb.append(DequeArr[back - 1]);
                    else sb.append(-1);
                    sb.append('\n');
                    break;
                default:
                    System.out.println("error");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();

    }

}