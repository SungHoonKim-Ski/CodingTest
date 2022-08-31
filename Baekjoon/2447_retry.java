import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] starsArr;
    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        starsArr = new char[n][n];
        calStars(0,0,n,false);

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(starsArr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

        return;
    }

    private static void calStars(int x, int y, int n, boolean isBlank){
        if(isBlank){
            for(int i = x; i<x+n; i++){
                for(int j=y; j<y+n; j++){
                    starsArr[i][j] = ' ';
                }
            }
            return;
        }

        if(n == 1){
            starsArr[x][y] = '*';
            return;
        }

        int count = 0;
        int size = n/3;
        for(int i=x; i<x+n; i+= size){
            for(int j=y; j<y+n; j+= size){
                calStars(i, j, size, (++count == 5) ? true : false);
            }
        }

    }
}