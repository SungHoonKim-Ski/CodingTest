import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n, m;

    static int[][] inputArr;

    static final int[][][] s1 = {
            {
                    {1, 1, 1, 1}
            },
            {
                    {1},
                    {1},
                    {1},
                    {1}
            }
    };

    static final int[][][] s2 = {
            {
                    {1, 1},
                    {1, 1}
            }
    };

    static final int[][][] s3 = {
            {
                    {1, 0},
                    {1, 0},
                    {1, 1}
            },
            {
                    {0, 1},
                    {0, 1},
                    {1, 1}
            },
            {
                    {1, 1, 1},
                    {1, 0, 0}
            },
            {
                    {1, 1, 1},
                    {0, 0, 1}
            },
            {
                    {1, 1},
                    {0, 1},
                    {0, 1}
            },
            {
                    {1, 1},
                    {1, 0},
                    {1, 0}
            },
            {
                    {0, 0, 1},
                    {1, 1, 1}
            },
            {
                    {1, 0, 0},
                    {1, 1, 1}
            }
    };

    static final int[][][] s4 = {
            {
                    {1, 0},
                    {1, 1},
                    {0, 1}
            },
            {
                    {0, 1},
                    {1, 1},
                    {1, 0}
            },
            {
                    {0, 1, 1},
                    {1, 1, 0}
            },
            {
                    {1, 1, 0},
                    {0, 1, 1}
            }
    };

    static final int[][][] s5 = {
            {
                    {1, 0},
                    {1, 1},
                    {1, 0}
            },
            {
                    {1, 1, 1},
                    {0, 1, 0}
            },
            {
                    {0, 1},
                    {1, 1},
                    {0, 1}
            },
            {
                    {0, 1, 0},
                    {1, 1, 1}
            }
    };


    static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inputArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                inputArr[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() throws IOException{

        int maxSum = 0;

        for (int type = 0; type < s1.length; type++) {

            for (int y = 0; y < n - s1[type].length + 1; y++) {
                for (int x = 0; x < m - s1[type][0].length + 1; x++) {

                    int curSum = 0;
                    for (int i = 0; i < s1[type].length; i++) {
                        for (int j = 0; j < s1[type][0].length; j++) {
                            if (s1[type][i][j] == 0) continue;
                            curSum += inputArr[y + i][x + j];
                        }
                    }
                    maxSum = Math.max(curSum, maxSum);
                }
            }
        }

        for (int type = 0; type < s2.length; type++) {

            for (int y = 0; y < n - s2[type].length + 1; y++) {
                for (int x = 0; x < m - s2[type][0].length + 1; x++) {

                    int curSum = 0;
                    for (int i = 0; i < s2[type].length; i++) {
                        for (int j = 0; j < s2[type][0].length; j++) {
                            if (s2[type][i][j] == 0) continue;
                            curSum += inputArr[y + i][x + j];
                        }
                    }
                    maxSum = Math.max(curSum, maxSum);
                }
            }
        }

        for (int type = 0; type < s3.length; type++) {

            for (int y = 0; y < n - s3[type].length + 1; y++) {
                for (int x = 0; x < m - s3[type][0].length + 1; x++) {

                    int curSum = 0;
                    for (int i = 0; i < s3[type].length; i++) {
                        for (int j = 0; j < s3[type][0].length; j++) {
                            if (s3[type][i][j] == 0) continue;
                            curSum += inputArr[y + i][x + j];
                        }
                    }
                    maxSum = Math.max(curSum, maxSum);
                }
            }
        }

        for (int type = 0; type < s4.length; type++) {

            for (int y = 0; y < n - s4[type].length + 1; y++) {
                for (int x = 0; x < m - s4[type][0].length + 1; x++) {

                    int curSum = 0;
                    for (int i = 0; i < s4[type].length; i++) {
                        for (int j = 0; j < s4[type][0].length; j++) {
                            if (s4[type][i][j] == 0) continue;
                            curSum += inputArr[y + i][x + j];
                        }
                    }
                    maxSum = Math.max(curSum, maxSum);
                }
            }
        }

        for (int type = 0; type < s5.length; type++) {

            for (int y = 0; y < n - s5[type].length + 1; y++) {
                for (int x = 0; x < m - s5[type][0].length + 1; x++) {

                    int curSum = 0;
                    for (int i = 0; i < s5[type].length; i++) {
                        for (int j = 0; j < s5[type][0].length; j++) {
                            if (s5[type][i][j] == 0) continue;
                            curSum += inputArr[y + i][x + j];
                        }
                    }
                    maxSum = Math.max(curSum, maxSum);
                }
            }
        }

        for (int type = 0; type < s1.length; type++) {

            for (int y = 0; y < n - s1[type].length + 1; y++) {
                for (int x = 0; x < m - s1[type][0].length + 1; x++) {

                    int curSum = 0;
                    for (int i = 0; i < s1[type].length; i++) {
                        for (int j = 0; j < s1[type][0].length; j++) {
                            if (s1[type][i][j] == 0) continue;
                            curSum += inputArr[y + i][x + j];
                        }
                    }
                    maxSum = Math.max(curSum, maxSum);
                }
            }
        }

        System.out.println(maxSum);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}