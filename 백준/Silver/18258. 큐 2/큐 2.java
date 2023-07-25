import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] StackArr;


    static void input() throws IOException
    {
        N = Integer.parseInt(br.readLine());
        StackArr = new int[N];
    }

    static void pro() throws IOException
    {
        int top = 0, size = 0;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {

            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    StackArr[top++] = Integer.parseInt(st.nextToken());
                    size++;
                    break;
                case "pop":
                    if (size == 0) sb.append(-1);
                    else {
                        sb.append(StackArr[top - size]);
                        size--;
                    }
                    sb.append('\n');
                    break;
                case "size":
                    sb.append(size).append('\n');
                    break;
                case "empty":
                    if (size == 0) sb.append(1);
                    else sb.append(0);
                    sb.append('\n');
                    break;
                case "front":
                    if (size != 0) sb.append(StackArr[top - size]);
                    else sb.append(-1);
                    sb.append('\n');
                    break;
                case "back":
                    if (size != 0) sb.append(StackArr[top - 1]);
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