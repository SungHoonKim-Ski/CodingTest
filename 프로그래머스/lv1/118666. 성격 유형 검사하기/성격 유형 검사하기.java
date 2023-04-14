import java.util.*;
import java.io.*;

class Solution {
    
    static StringBuffer sb = new StringBuffer();
    
    static int[] scores = new int[8]; // R T C F J M A N
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        answer = pro(survey, choices);
        return answer;
    }
    
    public static String pro(String[] survey, int[] choices) {
        // R T C F J M A N
        for (int i = 0; i < survey.length; i++) {
            if(choices[i] == 4) continue;
            if(choices[i] > 4) {
                char s2 = survey[i].charAt(1);
                if(s2 == 'R') {
                    scores[0] += choices[i] - 4;
                    continue;
                }
                if(s2 == 'T') {
                    scores[1] += choices[i] - 4;
                    continue;
                }
                if(s2 == 'C') {
                    scores[2] += choices[i] - 4;
                    continue;
                }
                if(s2 == 'F') {
                    scores[3] += choices[i] - 4;
                    continue;
                }
                if(s2 == 'J') {
                    scores[4] += choices[i] - 4;
                    continue;
                }
                if(s2 == 'M') {
                    scores[5] += choices[i] - 4;
                    continue;
                }
                if(s2 == 'A') {
                    scores[6] += choices[i] - 4;
                    continue;
                }
                if(s2 == 'N') {
                    scores[7] += choices[i] - 4;
                    continue;
                }
            }else {
                char s2 = survey[i].charAt(0);
                if(s2 == 'R') {
                    scores[0] += 4 - choices[i];
                    continue;
                }
                if(s2 == 'T') {
                    scores[1] += 4 - choices[i];
                    continue;
                }
                if(s2 == 'C') {
                    scores[2] += 4 - choices[i];
                    continue;
                }
                if(s2 == 'F') {
                    scores[3] += 4 - choices[i];
                    continue;
                }
                if(s2 == 'J') {
                    scores[4] += 4 - choices[i];
                    continue;
                }
                if(s2 == 'M') {
                    scores[5] += 4 - choices[i];
                    continue;
                }
                if(s2 == 'A') {
                    scores[6] += 4 - choices[i];
                    continue;
                }
                if(s2 == 'N') {
                    scores[7] += 4 - choices[i];
                    continue;
                }
            }
        }// R T C F J M A N
        if(scores[0] >= scores[1]) {
            sb.append('R');
        }else {
            sb.append('T');
        }
        if(scores[2] >= scores[3]) {
            sb.append('C');
        }else {
            sb.append('F');
        }
        if(scores[4] >= scores[5]) {
            sb.append('J');
        }else {
            sb.append('M');
        }
        if(scores[6] >= scores[7]) {
            sb.append('A');
        }else {
            sb.append('N');
        }
        
        return sb.toString();
    }
    
}