import java.io.*;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int N;
    static int Times[];

    static void input() throws Exception{

        Times = new int[3];
        String[] time = br.readLine().split(" ");

        for (int i = 0; i < time.length; i++) { // 시작 - 종료시간 입력
            Times[i] = Integer.parseInt(time[i].replace(":", ""));
        }
    }

    static void pro() throws IOException{

        HashSet<String> enterNameSet = new HashSet<>();

        String inputStr = "";
        while ((inputStr = br.readLine()) != null) {
            String[] s = inputStr.split(" ");
            int eachTime = Integer.parseInt(s[0].replace(":", ""));
            // 시간 변환
            if (eachTime > Times[0]) break; // 시작시간이 지났다면 break
            else enterNameSet.add(s[1]); // 안지났다면 set에 add
        }

        int checkCnt = 0;

        if (inputStr != null) { // 앞에서 시작시간이 지난 값 1개를 받음
            while (true) {

                String[] s = inputStr.split(" ");
                int eachTime = Integer.parseInt(s[0].replace(":", ""));
                if (eachTime > Times[2]) break;
                // 시간 변환
                if (eachTime >= Times[1]){ //  && eachTime <= Times[2] 위에서 이미 체크
                    if (enterNameSet.contains(s[1])) {
                        enterNameSet.remove(s[1]);
                        checkCnt++;
                    }
                }
                inputStr = br.readLine();
                if (inputStr == null) break;
            }
        }
        System.out.println(checkCnt);

    }

    public static void main(String[] args) throws Exception{

        input();
        pro();

        System.out.println(sb);
    }

}