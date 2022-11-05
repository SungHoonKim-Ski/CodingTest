import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );

        List<Integer> userList = new ArrayList<>();
        while (st.hasMoreTokens()){
            userList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(userList);

        int c[] = new int[userList.size()];
        c[0] = userList.get(0);
        for(int i=1; i<userList.size(); i++){
            c[i] = userList.get(i) + c[i-1];
        }

        int sumTime = 0;
        for(int i=0; i<c.length; i++){
            sumTime+= c[i];
        }

        System.out.println(sumTime);
        return;
    }
}