import java.util.*;

class Solution {
    
    static int[] resArr = new int[2]; // x, y
    static ArrayList<int[]> pairArray = new ArrayList<>();
    
    
    public int[] solution(int brown, int yellow) {
        pro (brown, yellow);
        return resArr;
    }
    
    public void pro(int brown, int yellow) {
        
        calPair(yellow);
        for (int i = 0; i < pairArray.size(); i++) {
            int[] curPair = pairArray.get(i);
            System.out.println(curPair[0] + ", " + curPair[1]);
            if ((curPair[0] + curPair[1] + 2) * 2 == brown) {
                resArr[0] = Math.max(curPair[0], curPair[1]) + 2;
                resArr[1] = Math.min(curPair[0], curPair[1]) + 2;
                break;
            }
        }
    }
    
    public void calPair(int yellow) {
        
        if (yellow == 1) {
            pairArray.add(new int[] {1, 1});
            return;
        }
        
        for (int i = 1; i <= yellow / 2; i++) {
            
            if (yellow % i == 0) {
                pairArray.add(new int[] {i, yellow / i});
            }
            
        }
        
    }
    
    
}