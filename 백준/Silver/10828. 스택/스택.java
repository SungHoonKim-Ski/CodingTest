import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, Top, Size;
    static int[] StackArr;


    static void input() throws IOException
    {
        N = Integer.parseInt(br.readLine());
        StackArr = new int[N];
        Size = 0;
    }

    static void pro() throws IOException
    {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {

            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    StackArr[Size++] = Integer.parseInt(st.nextToken());
                    break;
                case "pop":
                    if (Size == 0) sb.append(-1);
                    else sb.append(StackArr[--Size]);
                    sb.append('\n');
                    break;
                case "size":
                    sb.append(Size).append('\n');
                    break;
                case "empty":
                    if (Size == 0) sb.append(1);
                    else sb.append(0);
                    sb.append('\n');
                    break;
                case "top":
                    if (Size != 0) sb.append(StackArr[Size - 1]);
                    else sb.append(-1);
                    sb.append('\n');
                    break;
                default:
                    System.out.println("error");
//                case "front":
//                    if (queue.isEmpty()) sb.append(-1);
//                    else sb.append(queue.peekFirst());
//                    sb.append('\n');
//                    break;
//                case "back":
//                    if (queue.isEmpty()) sb.append(-1);
//                    else sb.append(queue.peekLast());
//                    sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();

    }

}