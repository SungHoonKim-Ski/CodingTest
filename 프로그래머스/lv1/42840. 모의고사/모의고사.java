import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] res = pro(answers);
        return res;
    }
    
    public int[] pro(int[] answers) {
        int[] correctCnt = new int[3];
        int[][] rules = new int[3][];
        
        rules[0] = new int[] {1, 2, 3, 4, 5};
        rules[1] = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        rules[2] = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < correctCnt.length; j++) {
                if (rules[j][i % rules[j].length] == answers[i]) correctCnt[j]++;
            }
        }
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < correctCnt.length; i++) {
                maxScore = Math.max(maxScore, correctCnt[i]);
        }
        
        int maxScoreCnt = 0;
        for (int i = 0; i < correctCnt.length; i++) {
                if (maxScore == correctCnt[i]) maxScoreCnt++;
        }
        
        int[] resArr = new int[maxScoreCnt];
        int idx = 0;
        for (int i = 0; i < correctCnt.length; i++) {
                if (maxScore == correctCnt[i]) resArr[idx++] = i + 1;
        }
        Arrays.sort(resArr);
        
        return resArr;
    }
}