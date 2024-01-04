import java.util.*;
import java.io.*;

class Solution {
    
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    
    HashMap<String, Integer> nameIdxMap = new HashMap();
    int idx = 0;
    int n;
    
    int[] giftScore;
    int[][] giftArr;
    
    public int solution(String[] friends, String[] gifts) {
        
        n = friends.length;
        giftScore = new int[n];
        giftArr = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            nameIdxMap.put(friends[i], idx++);
        }
        
        for (int i = 0; i < gifts.length; i++) {
            st = new StringTokenizer(gifts[i]);
            int giveIdx = nameIdxMap.get(st.nextToken());
            int getIdx = nameIdxMap.get(st.nextToken());
            
            giftScore[giveIdx]++;
            giftScore[getIdx]--;
            
            giftArr[giveIdx][getIdx]++;
        }
        
        int answer = pro();
        return answer;
    }
    
    int pro() {
        
        int[] giftCnt = new int[n];
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                
                int iToJScore = giftArr[i][j];
                int jToIScore = giftArr[j][i];
                
                if (iToJScore != jToIScore) {
                    if (iToJScore > jToIScore) {
                        giftCnt[i]++;
                    } else {
                        giftCnt[j]++;                        
                    }
                } else {
                    int iScore = giftScore[i];
                    int jScore = giftScore[j];
                    
                    if (iScore != jScore) {
                        if (iScore > jScore) {
                            giftCnt[i]++;
                        } else giftCnt[j]++;
                    } 
                }
            }
        }
        
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(giftCnt[i], res);
        }
        
        return res;
    }
}