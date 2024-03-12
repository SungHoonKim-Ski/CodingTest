import java.util.*;

class Solution {
    
    long[] aDp, bDp;
    long[] aSeq, bSeq;
    int n;
    
    public long solution(int[] sequence) {
        n = sequence.length;
        aDp = new long[n];
        bDp = new long[n];
        aSeq = new long[n];
        bSeq = new long[n];
        Arrays.fill(aDp, Integer.MIN_VALUE);
        Arrays.fill(bDp, Integer.MIN_VALUE);
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                aSeq[i] = sequence[i] * -1;
                bSeq[i] = sequence[i];
            } else {
                aSeq[i] = sequence[i];
                bSeq[i] = sequence[i] * -1;
            }
        }
        
        aDp[0] = aSeq[0];
        bDp[0] = bSeq[0];
        
        aDp[1] = Math.max(aDp[0], Math.max(aDp[0] + aSeq[1], aSeq[1]));
        bDp[1] = Math.max(bDp[0], Math.max(bDp[0] + bSeq[1], bSeq[1]));
        
        for (int i = 2; i < n; i++) {
            
            if (aDp[i - 2] + aSeq[i - 1] != aDp[i - 1] && aDp[i - 1] != aSeq[i - 1]) { // 연속이 아니라면
                aDp[i] = Math.max(aDp[i - 1], aSeq[i]);
            } else {
                aDp[i] = Math.max(aDp[i - 1], Math.max(aDp[i - 1] + aSeq[i], aSeq[i]));
            }
            
            if (bDp[i - 2] + bSeq[i - 1] != bDp[i - 1] && bDp[i - 1] != bSeq[i - 1]) { // 연속이 아니라면
                bDp[i] = Math.max(bDp[i - 1], bSeq[i]);
            } else {
                bDp[i] = Math.max(bDp[i - 1], Math.max(bDp[i - 1] + bSeq[i], bSeq[i]));
            }
        }
        long answer = Math.max(aDp[n - 1], bDp[n - 1]);
        return answer;
    }
    
    
}