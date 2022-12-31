import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringBuffer sb;
    static char[][] games;
    static boolean[][] curGameColor;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean isPang = true;
    static boolean curColorPang;
    static int pangCount = 0;

    static int curPangStack = 1;

    enum Color {R, G, B, P, Y}

    static Color curColor;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        games = new char[12][6];
        curGameColor = new boolean[12][6];
        for (int i=0; i<12; i++){
            games[i] = br.readLine().toCharArray();
        }

        while (isPang) {
            isPang = false;
            for(Color color : Color.values()) {
                initCurColorGame(color);
                curColor = color;
                curColorPang = false;
                for (int y=0; y<12; y++) {
                    for (int x = 0; x < 6; x++) {
                        if (curGameColor[y][x]) {
                            curPangStack = 1;
                            BFS(y, x);
                            if (curColorPang) {
                                Pang();
                                isPang = true;
                                curColorPang = false;
                                curPangStack = 1;
                            } else {
                                RollbackColor(curColor);
                            }
                        }
                    }
                }
            }

            if (isPang) {
                pangCount++;
                for (int y = 11; y > 0; y--) {
                    for (int x = 0; x < 6; x++) {
                        AfterPang(y, x);
                    }
                }
            }
        }
        System.out.println(pangCount);
    }
    static void initCurColorGame(Color color){
        char curColor = color.toString().charAt(0);
        for (int y=0; y<12; y++) {
            for (int x=0; x<6; x++) {
                if(games[y][x] == curColor) {
                    curGameColor[y][x] = true;
                }else {
                    curGameColor[y][x] = false;
                }
            }
        }
    }

    static void BFS(int y, int x) {

        curGameColor[y][x] = !curGameColor[y][x];
        games[y][x] = 'X';

        for (int i=0; i<4; i++) {
            int prevY = y + dy[i];
            int prevX = x + dx[i];
            if (prevY >= 0 && prevX >= 0 && prevY < 12 && prevX < 6) {
                if (curGameColor[prevY][prevX]) {
                    curPangStack++;
                    if (curPangStack >= 4) {
                        curColorPang = true;
                    }
                    BFS(prevY, prevX);
                }
            }
        }
    }


    static void RollbackColor(Color color) {
        for (int y=0; y<12; y++) {
            for (int x=0; x<6; x++) {
                if (games[y][x] == 'X') {
                    games[y][x] = color.toString().charAt(0);
                }
            }
        }
    }
    static void Pang() {
        for (int y=0; y<12; y++) {
            for (int x=0; x<6; x++) {
                if (games[y][x] == 'X') {
                    games[y][x] = '.';
                }
            }
        }
    }

    static void AfterPang(int y, int x) {
        if (games[y][x] == '.') {
            for(int i = y-1; i >= 0; i--) {
                if (games[i][x] != '.') {
                    games[y][x] = games[i][x];
                    games[i][x] = '.';
                    return;
                }
            }
        }
    }

}