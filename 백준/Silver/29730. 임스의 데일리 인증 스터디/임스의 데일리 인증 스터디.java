import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
//        HashSet<String> set1 = new HashSet<>();
//        HashSet<String> set2 = new HashSet<>();
        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.contains("boj.kr/"))list2.add(s);
            else list1.add(s);
        }


        Collections.sort(list1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) return o1.compareTo(o2);
                else return o1.length() - o2.length();
            }
        });
        Collections.sort(list2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) return o1.compareTo(o2);
                else return o1.length() - o2.length();
            }
        });

        for (String s : list1) sb.append(s).append('\n');
        for (String s : list2) sb.append(s).append('\n');
        System.out.println(sb);
    }
}