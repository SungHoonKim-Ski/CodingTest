import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static HashMap<String, Float> map;

    static void init() {
        map = new HashMap<>();
        map.put("A+", 4.3f);
        map.put("A0", 4.0f);
        map.put("A-", 3.7f);
        map.put("B+", 3.3f);
        map.put("B0", 3.0f);
        map.put("B-", 2.7f);
        map.put("C+", 2.3f);
        map.put("C0", 2.0f);
        map.put("C-", 1.7f);
        map.put("D+", 1.3f);
        map.put("D0", 1.0f);
        map.put("D-", 0.7f);
        map.put("F", 0.0f);
    }

    static void input() throws IOException{

    }

    static void pro() throws IOException{
        System.out.println(map.get(br.readLine()));
    }

    public static void main(String[] args) throws IOException{
        init();
        input();
        pro();

    }

}