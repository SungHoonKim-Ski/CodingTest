import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, k;

    static int[][] feed, add;
    static ArrayList<Integer>[][] treeList;
    static Deque<Integer>[][] treeQue;
    static int[][] spread;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        feed = new int[n + 1][n + 1];
        treeQue = new ArrayDeque[n + 1][n + 1];
        treeList = new ArrayList[n + 1][n + 1];
        spread = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                treeQue[i][j] = new ArrayDeque<Integer>();
                treeList[i][j] = new ArrayList<>();
                feed[i][j] = 5;
            }

        add = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                add[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            treeList[r][c].add(age);
        }
    }

    public static void pro() {
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                Collections.sort(treeList[i][j]);
                treeQue[i][j].addAll(treeList[i][j]);
            }


        while (k-- > 0) {
            springSummer();
            autumn();
            winter();
        }

        int count = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                count += treeQue[i][j].size();

        System.out.println(count);
    }

    static void springSummer() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                Deque<Integer> curTreeQue = treeQue[i][j];
                List<Integer> growTree = new ArrayList<>();
                List<Integer> deadTree = new ArrayList<>();

                while (!curTreeQue.isEmpty()) {
                    int curTree = curTreeQue.poll();
                    if (feed[i][j] >= curTree) {
                        feed[i][j] -= curTree;
                        growTree.add(curTree + 1);
                    } else {
                        deadTree.add(curTree);
                        deadTree.addAll(curTreeQue);
                        curTreeQue.clear();
                    }
                }
                treeQue[i][j].addAll(growTree);

                for (int dead : deadTree) {
                    feed[i][j] += dead / 2;
                }
            }
        }
    }

    static void autumn() {
        int[] dr = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dc = {1, 0, -1, 1, -1, 1, 0, -1};

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                Deque<Integer> curTreeQue = treeQue[i][j];
                for (int curTree : curTreeQue) {
                    if (curTree % 5 == 0) spread[i][j]++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (spread[i][j] == 0) continue;
                for (int k = 0; k < 8; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (nr <= 0 || nc <= 0 || nr > n || nc > n) continue;
                    for (int x = 0; x < spread[i][j]; x++) {
                        treeQue[nr][nc].addFirst(1);
                    }
                }
                spread[i][j] = 0;
            }
        }
    }

    static void winter() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                feed[i][j] += add[i][j];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}