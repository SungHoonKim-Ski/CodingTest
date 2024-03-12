import java.util.*;

class Solution {
    
    long[] aDp, bDp;
    long[] aSeq, bSeq;
    int n;
    
    public long solution(int[] sequence) {
        n = sequence.length;
        
        if (n == 1) return Math.max(sequence[0], -sequence[0]);
        
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
        
        aDp[1] = Math.max(aDp[0], 0) + aSeq[1];
        bDp[1] = Math.max(bDp[0], 0) + bSeq[1];

        long answer = Integer.MIN_VALUE;

        for (int i = 2; i < n; i++) {
            aDp[i] = Math.max(aDp[i - 1], 0) + aSeq[i];
            answer = Math.max(aDp[i], answer);
            bDp[i] = Math.max(bDp[i - 1], 0) + bSeq[i];
            answer = Math.max(bDp[i], answer);
        }
//        System.out.println(Arrays.toString(aDp));
//        System.out.println(Arrays.toString(bDp));
        return answer;
    }
    
    
}