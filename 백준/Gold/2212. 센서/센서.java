import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int n, k;

    static int[] nArr;

    public static void input() throws IOException{


        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        nArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nArr[i] = Integer.parseInt(st.nextToken());
    }

    public static void pro() {

        if (n <= k) {
            System.out.println(0);
        } else {
            Arrays.sort(nArr);
            ArrayList<Integer> difList = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                difList.add(nArr[i + 1] - nArr[i]);
            }

            Collections.sort(difList);

            int sum = 0;
            for (int i = 0; i < n - k; i++) {
                sum += difList.get(i);
            }
            System.out.println(sum);
        }
    }



    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}