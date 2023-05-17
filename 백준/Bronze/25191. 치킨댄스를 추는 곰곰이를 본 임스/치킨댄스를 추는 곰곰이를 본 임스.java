import java.io.*;
import java.util.StringTokenizer;

class Main {


    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;


    static int 치킨, 콜라, 맥주;

    static void input() throws IOException {

        치킨 = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        콜라 = Integer.parseInt(st.nextToken());
        맥주 = Integer.parseInt(st.nextToken());
    }

    static void pro(){

        int 시켜먹는치킨 = 0;

        시켜먹는치킨 += 콜라 / 2;
        시켜먹는치킨 += 맥주;

        if (시켜먹는치킨 > 치킨) 시켜먹는치킨 = 치킨;
        System.out.println(시켜먹는치킨);
    }

    public static void main(String[] args) throws Exception{

        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input.txt")));

        input();
        pro();
    }

   
}