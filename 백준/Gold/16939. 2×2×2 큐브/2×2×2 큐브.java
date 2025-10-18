import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] arr;
    static int MAX = 24;


    static void input() throws IOException{
        arr = new int[MAX + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= MAX; i++) arr[i] = Integer.parseInt(st.nextToken());
    }
    
    static void pro() {
        int[][][] swapCase = {
            {
                {1,3,6,8},
                {5,7,10,12},
                {9,11,21,23},
                {22,24,2,4},
                {13,14,15,16},
                {17,18,19,20}
            },
            {
                {9,11,6,8},
                {5,7,2,4},
                {22,24,10,12},
                {1,3,21,23},
                {13,14,15,16},
                {17,18,19,20}
            },
            {
                {21,22,15,16},
                {7,8,13,14},
                {19,20,5,6},
                {23,24,17,18},
                {1,2,3,4},
                {9,10,11,12}
            },
            {
                {13,14,23,24},
                {5,6,15,16},
                {17,18,7,8},
                {21,22,19,20},
                {1,2,3,4},
                {9,10,11,12}
            },
            {
                {1,2,17,19},
                {18,20,9,10},
                {11,12,14,16},
                {13,15,3,4}
            },
            {
                {1,2,14,16},
                {13,15,9,10},
                {11,12,17,19},
                {18,20,3,4}
            }
        };

        for (int i = 0; i < swapCase.length; i++) {
            boolean flag = true;
            for (int j = 0; j < swapCase[i].length; j++) {
                for (int k = 1; k < swapCase[i][j].length; k++) {
                    if (arr[swapCase[i][j][k - 1]] != arr[swapCase[i][j][k]]) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) break;
            }
            if (flag) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}