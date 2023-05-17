import java.io.*;
import java.util.StringTokenizer;

class Solution {


    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;


    static int Max = 1000;
    static int A, B;

    static boolean[] isPalindrome;
    static boolean[] isSqrtPalindrome;

    static void init() {
        isPalindrome = new boolean[Max + 1];
        isSqrtPalindrome = new boolean[Max + 1];
        for (int i = 1; i <= Max; i++) {
            if (!isPalindrome[i]) {
                if (!checkPalindrome(i)) continue;
            }
            double d = Math.sqrt(i);
            if (d != (int)d) continue;
            isPalindrome[i] = checkPalindrome((int)d);
            if (isPalindrome[i]) isSqrtPalindrome[i] = true;
        }

    }

    static boolean checkPalindrome (int x) {

        char[] cArr = String.valueOf(x).toCharArray();

        for (int i = 0; i < cArr.length / 2; i++) {
            if (cArr[i] != cArr[cArr.length - 1 - i]) return false;
        }
        isPalindrome[x] = true;
        return true;
    }


    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    static void pro(int tc) throws Exception{

        int res = 0;
        for (int i = A; i <= B; i++) if (isSqrtPalindrome[i]) res++;
        sb.append(String.format("#%d %d\n", tc, res));
    }

    public static void main(String[] args) throws Exception{

        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input.txt")));
        init();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            input();
            pro(tc);
        }
        System.out.println(sb);

    }

}