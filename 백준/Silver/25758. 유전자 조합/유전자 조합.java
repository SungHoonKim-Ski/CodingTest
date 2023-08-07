import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    static ArrayList<String> InputList;

    static HashSet<String> MixSet;

    static void input() throws IOException
    {
        N = Integer.parseInt(br.readLine());
        //InputList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        HashSet<String> inputSet = new HashSet<>();
        HashSet<String> sameSet = new HashSet<>();
        while (N-- > 0) {
            String s = st.nextToken();
            if (!inputSet.add(s)) sameSet.add(s);
        }
        InputList = new ArrayList<>(inputSet);
        InputList.addAll(sameSet);
        MixSet = new HashSet<>();
    }

    static void pro()
    {
        // 가능한 조합은 문자를 앞 / 뒤에 붙일 수 있으므로 고려
        mix();
        LinkedList<Character> printType = calPrintType();
        sb.append(printType.size()).append('\n');
        for (char c : printType) {
            sb.append(c).append(' ');
        }
        System.out.println(sb);
    }

    static void mix() { // 가능한 모든 조합의 수
        for (int i = 0; i < InputList.size() - 1; i++) {
            for (int j = i + 1; j < InputList.size(); j++) {
                MixSet.add(InputList.get(i).charAt(0) + "" + InputList.get(j).charAt(1));
                MixSet.add(InputList.get(j).charAt(0) + "" + InputList.get(i).charAt(1));
            }
        }
    }

    static LinkedList<Character> calPrintType() {

        HashSet<Character> printType = new HashSet<>();
        for (String s : MixSet) {
            char front = s.charAt(0);
            char back = s.charAt(1);
            if (front == back) printType.add(front);
            else if (front > back) printType.add(front);
            else printType.add(back);
        }
        LinkedList<Character> sortList = new LinkedList<>(printType);
        Collections.sort(sortList);
        return sortList;
    }


    public static void main(String[] args) throws Exception{

        input();
        pro();
    }

}