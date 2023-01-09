import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for (int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[][] intMap = new int[N][N];

        int[] dy = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] dx = {1, -1, 1, 0, -1, 1, 0, -1};
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] != '.') {
                    for (int k=0; k<8; k++) {
                        int curY = dy[k] + i;
                        int curX = dx[k] + j;
                        if (curX >= 0 && curY >= 0 && curX < N && curY < N) {
                            if (map[curY][curX] == '.') {
                                intMap[curY][curX] += (map[i][j] - '0');
                            }
                        }
                    }
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (intMap[i][j] == 0) {
                    if (map[i][j] == '.'){
                        sb.append(0);
                    }else {
                        sb.append('*');
                    }
                }else if (intMap[i][j] > 9) {
                    sb.append('M');
                }else {
                    sb.append(intMap[i][j]);
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}