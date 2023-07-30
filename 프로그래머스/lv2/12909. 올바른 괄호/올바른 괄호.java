import java.util.*;
import java.io.*;

class Solution {
    
    boolean solution(String s) {
        boolean answer = pro(s.toCharArray());

        return answer;
    }
    
    boolean pro(char[] str) {
        
        Stack<Character> stack = new Stack<>();
        
        int openCnt = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') openCnt++;
            else {
                if (openCnt == 0) return false;
                if (openCnt > 0) openCnt--;
                else return false;
            }
            
        }
        if (openCnt == 0) return true;
        else return false;
    
        
    }
    
}