import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append('#').append(test_case).append(' ');
            char[] schoolChar = br.readLine().toCharArray();
            int[][] dp = new int[10001][16];
            int result = 0;

            for (int day=0; day<schoolChar.length; day++) {
                int admin = 1 << (schoolChar[day] - 'A');
                for (int i=1; i<16; i++) {
                    if (day == 0) {
                        if (((i & admin) != 0 && (i & 1) != 0)) {
                            dp[day][i] = 1;
                        }
                        continue;
                    }
                    if (dp[day-1][i] != 0) {
                        for (int j=1; j<16; j++) {
                            if ((i & j) != 0 && (j & admin) != 0) {
                                dp[day][j] += dp[day-1][i];
                                dp[day][j] %= 1000000007;
                            }
                        }
                    }
                }
            }
            for (int i=1; i<16; i++) {
                result += dp[schoolChar.length-1][i];
                result %= 1000000007;
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}

