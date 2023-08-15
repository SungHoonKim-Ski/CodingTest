import java.util.*;
import java.io.*;
import java.math.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    
    static ArrayList<Person> Peolpe;
    static int N;
    
    public static class Person{
        int score1, score2;
        
        Person(int score1, int score2) {
            this.score1 = score1;
            this.score2 = score2;
        }
    }
    
    public static void input() throws IOException{
        
        N = Integer.parseInt(br.readLine());
        Peolpe = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Peolpe.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    public static void pro() {

        Collections.sort(Peolpe, (o1, o2) -> o1.score1 - o2.score1);
        int res = 1;
        int min = Peolpe.get(0).score2;

        for (int i = 1; i < N; i++) {
            if (Peolpe.get(i).score2 < min) {
                res++;
                min = Peolpe.get(i).score2;
            }
        }
        sb.append(res).append('\n');

    }




    public static void main(String args[]) throws IOException
    {
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }
}