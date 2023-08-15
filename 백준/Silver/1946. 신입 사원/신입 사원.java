import java.util.*;
import java.io.*;
import java.math.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    
    static Person[] Peolpe; 
    static int N;
    
    public static class Person implements Comparable<Person> {
        int score1, score2;
        
        Person(int score1, int score2) {
            this.score1 = score1;
            this.score2 = score2;
        }
        @Override
        public int compareTo(Person o) {
            return this.score1 - o.score1;
        }
    }
    
    public static void input() throws IOException{
        
        N = Integer.parseInt(br.readLine());
        Peolpe = new Person[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Peolpe[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    public static void pro() {

        Arrays.sort(Peolpe);

        int res = 1;
        int min = Peolpe[0].score2;

        for (int i = 1; i < N; i++) {
            if (Peolpe[i].score2 < min) {
                res++;
                min = Peolpe[i].score2;
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