import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
// 물통의 현재 상태와 물을 붓는 행위를 관리하는 구조체
class State{
    int[] X;
    State(int[] _X){
        X = new int[3];
        for (int i=0;i<3;i++) X[i] = _X[i];
    }

    State move(int from,int to,int[] Limit){
        // from 물통에서 to 물통으로 물을 옮긴다.
        int[] nX = new int[]{X[0], X[1], X[2]};
        /* TODO */
        return new State(nX);
    }
};

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] Limit;
    static int N;
    static char[] arr;
    static boolean[] possible;
    static boolean[][][] visit;

    static void input() {
//        Limit = new int[3];
//        for (int i=0;i<3;i++) Limit[i] = scan.nextInt();
//        visit = new boolean[205][205][205];
//        possible = new boolean[205];
        N = scan.nextInt();
        arr = scan.next().toCharArray();
    }

    // 물통 탐색 시작~
    static void bfs(int x1, int x2, int x3) {

        Queue<State> Q = new LinkedList<>();

        // BFS 과정 시작
        /* TODO */
    }

    static void pro() {
//        bfs(0, 0, Limit[2]);
        // 정답 계산하기
        /* TODO */
        long res = 0;
        long hash = 1;
        for (int i = 0; i < N; i++) {
            res += (arr[i] - 'a' + 1) * hash % 1234567891;
            hash *= 31;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        // BufferedReader의 빠른 속도,
        // + Scanner의 타입별 입력값을 받는 기능을 혼합
        // (자바 내부에 구현된 Scanner는 속도가 느림)
        // 다른분의 코드를 참고한 코드
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}