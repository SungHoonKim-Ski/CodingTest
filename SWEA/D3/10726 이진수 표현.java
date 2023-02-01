import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        StringBuffer sb = new StringBuffer();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append('#').append(test_case).append(' ');
            int binaryCount = sc.nextInt();
            int input = Integer.parseInt(sc.next());
            int compare = 1;
            for (int i=1; i<binaryCount; i++) {
                compare = compare << 1;
                compare += 1;
            }

            if((input & compare) == compare) sb.append("ON");
            else sb.append("OFF");
            sb.append('\n');

        }
        System.out.println(sb);
    }
}