import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int max = m;
        
        for (int i = 0; i < 24; i++) {
            if (map.containsKey(i)) max -= m * map.get(i);
            
            int cur = players[i];            
            if (cur < max) continue;
            
            int add = (cur - max) / m + 1;
            answer += add;
            max += (add * m);
            map.put(i + k, add);
            
        }
        
        
        return answer;
    }
}