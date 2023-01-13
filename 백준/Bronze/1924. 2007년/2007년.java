import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {

    public enum Day{SUN, MON, TUE, WED, THU, FRI, SAT}
    public static void main(String[] args) throws IOException {

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> dayMap = new HashMap();
        dayMap.put(1, 31);
        dayMap.put(2, 28);
        dayMap.put(3, 31);
        dayMap.put(4, 30);
        dayMap.put(5, 31);
        dayMap.put(6, 30);
        dayMap.put(7, 31);
        dayMap.put(8, 31);
        dayMap.put(9, 30);
        dayMap.put(10, 31);
        dayMap.put(11, 30);
        dayMap.put(12, 31);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dayCount = y;
        for (int i=1; i<x; i++) {
            dayCount += dayMap.get(i);
        }
        dayCount %= 7;
        System.out.println(Day.values()[dayCount]);
    }
}
