import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int skillCount = 0;
        int LRCount = 0;
        int SKCount = 0;

        int n = Integer.parseInt(br.readLine());
        char[] skill = br.readLine().toCharArray();

        for (int i=0; i<n; i++) {
            if (skill[i] < 'A'){
                skillCount++;
                continue;
            }else if (skill[i] == 'L') {
                LRCount++;
            }else if (skill[i] == 'R') {
                if (LRCount > 0){
                    LRCount--;
                    skillCount++;
                }else break;
            }else if (skill[i] == 'S') {
                SKCount++;
            }else if (skill[i] == 'K') {
                if (SKCount > 0){
                    SKCount--;
                    skillCount++;
                }else break;
            }
        }

        System.out.println(skillCount);
    }

}