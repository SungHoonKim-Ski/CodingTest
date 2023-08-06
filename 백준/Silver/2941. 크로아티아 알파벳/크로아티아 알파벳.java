import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static HashSet<Character> ContainsChar;
    static ArrayList<String> CheckArr;
    static char[] InputCharArr;

    static void init() {
        ContainsChar = new HashSet<>();

        ContainsChar.add('c');
        ContainsChar.add('d');
        ContainsChar.add('l');
        ContainsChar.add('n');
        ContainsChar.add('s');
        ContainsChar.add('z');
        int i = 0;
        
        CheckArr = new ArrayList<String>();
        CheckArr.add("c=");
        CheckArr.add("c-");
        CheckArr.add("d-");
        CheckArr.add("lj");
        CheckArr.add("nj");
        CheckArr.add("s=");
        CheckArr.add("z=");
        CheckArr.add("dz=");
    }

    static void input() throws IOException
    {
        InputCharArr = br.readLine().toCharArray();
    }

    static void pro() throws IOException
    {
        int cnt = 0;
        List<Character> test;

        for (int i = 0; i < InputCharArr.length; i++) {
            StringBuilder sb = new StringBuilder();

            if (ContainsChar.contains(InputCharArr[i])) {
                if (i == InputCharArr.length - 1) {
                    cnt++;
                    continue;
                }
                sb.append(InputCharArr[i]).append(InputCharArr[i + 1]);
                if (i != InputCharArr.length - 2) {
                    sb.append(InputCharArr[i + 2]);
                    if (sb.toString().equals(CheckArr.get(CheckArr.size() - 1))) {
                        i += 2;
                        cnt++;
                        continue;
                    }
                    sb.setLength(sb.length() - 1);
                }
                boolean isChecked = false;
                for (int j = 0; j < CheckArr.size() - 1; j++) {
                    if (sb.toString().equals(CheckArr.get(j))) {
                        i++;
                        cnt++;
                        isChecked = true;
                        break;
                    }
                }
                if (!isChecked) cnt++;
            }else cnt++;
        }

        System.out.println(cnt);
    }


    public static void main(String[] args) throws Exception{

        init();
        input();
        pro();

    }

}