import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        int TC, MARK;

//        System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TC = Integer.parseInt(st.nextToken());

        for (int testcase = 1; testcase <= TC; ++testcase) {
            List<String> list = new ArrayList<>();
            int res = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int strCnt = str.length();
            list.add(String.valueOf(str.charAt(strCnt - 1)));
            for (int i = 1; i < strCnt; i++) {
                list.add(str.charAt(strCnt - i - 1) + list.get(i - 1));
            }
            Collections.sort(list);
            System.out.println("#" + testcase + " " + list.get(res - 1));
        }

        br.close();
    }
}