import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static double monsterDef, userDef;
    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        monsterDef = Float.parseFloat(st.nextToken());
        userDef = Float.parseFloat(st.nextToken());
    }

    static void pro() {
        double def = monsterDef - monsterDef / 100 * userDef;
        if (def >= 100) System.out.println(0);
        else System.out.println(1);
    }


    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}