import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution{

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){

            char[] inputArr = br.readLine().toCharArray();
            char[] findArr = br.readLine().toCharArray();
            int inputLen = inputArr.length;
            int findLen = findArr.length;

            long inputHash1 = 0, inputHash2 = 0, findHash1 = 0, findHash2 = 0, pow1 = 1, pow2 = 1;
            int res = 0;
            for(int i = 0; i <= inputLen - findLen; i++) {
                if(i == 0) {
                    for(int j = 0; j < findLen; j++) {
                        inputHash1 += inputArr[findLen - 1 - j] * pow1;
                        inputHash2 += inputArr[findLen - 1 - j] * pow2;
                        findHash1 += findArr[findLen - 1 - j] * pow1;
                        findHash2 += findArr[findLen - 1 - j] * pow2;

                        if(j < findLen - 1) {
                            pow1 *= 89;
                            pow2 *= 97;
                        }
                    }

                } else {
                    inputHash1 = 89 * inputHash1 - 89 * inputArr[i-1] * pow1 + inputArr[i+findLen-1];
                    inputHash2 = 97 * inputHash2 - 97 * inputArr[i-1] * pow2 + inputArr[i+findLen-1];
                }

                if(inputHash1 == findHash1) {
                    if (inputHash2 == findHash2) res++;
                }
            }
            System.out.println("#" + tc + " " + res);
        }
    }
}