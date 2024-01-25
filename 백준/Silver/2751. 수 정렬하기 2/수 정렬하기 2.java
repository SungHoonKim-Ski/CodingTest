import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br;
    private static StringBuffer sb;

    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        int count = Integer.parseInt(br.readLine());
        List<Integer> sortList = new ArrayList<>();
        for(int i=0; i<count; i++){
            sortList.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(sortList);
        for(int i=0; i<count; i++){
            sb.append(sortList.get(i) + " ");
        }
        System.out.println(sb);
    }

}