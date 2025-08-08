import java.util.*;

class Solution {
    
    public int solution(int storey) {
        int count = 0;
        
        while (storey != 0) {
            int cur = storey % 10;
            storey /= 10;
            if (cur == 5) {
                if (storey % 10 >= 5) {
                    storey++;
                } 
            }
            
            if (cur > 5) {
                storey++;
                count += 10 - cur;
            } else {
                count += cur;
            }
        }
        
        return count;
    }
    
}