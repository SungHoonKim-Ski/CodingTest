import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] NameChar;
    static int N;
    static List<String> CandidateStr;
    static int[] DefaultScore;
    static char[] LOVEChar;

    public static void input() throws Exception {

        LOVEChar = new char[4];
        LOVEChar[0] = 'L';
        LOVEChar[1] = 'O';
        LOVEChar[2] = 'V';
        LOVEChar[3] = 'E';
//        inputInt = new BigInteger(br.readLine());
        NameChar = br.readLine().toCharArray();
        N = Integer.parseInt(br.readLine());
        CandidateStr = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            CandidateStr.add(br.readLine());
        }
        Collections.sort(CandidateStr);
    }

    public static void pro() throws Exception {

        DefaultScore = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < NameChar.length; j++) {
                if (LOVEChar[i] == NameChar[j]) DefaultScore[i]++;
            }
        }

        int maxIdx = -1, maxScore = -1;
        for (int i = 0; i < N; i++) {
            int curScore = calScore(i);
            if (maxScore < curScore) {
                maxScore = curScore;
                maxIdx = i;
            }
        }
        System.out.println(CandidateStr.get(maxIdx));

    }

    static int calScore(int idx) {

        char[] candidateChar = CandidateStr.get(idx).toCharArray();
        int candidateCharLen = CandidateStr.get(idx).length();
        int[] score = DefaultScore.clone();

        for (int i = 0; i < 4; i++) {
            for (char c : candidateChar) {
                if (LOVEChar[i] == c) score[i]++;
            }
        }

        int sum = 1;

        for (int i = 0; i < score.length - 1; i++) {
            for (int j = i + 1; j < score.length; j++) {
                sum *= score[i] + score[j];
            }
        }

        return sum % 100;
    }




    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}