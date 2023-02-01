import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        UserSolution userSolution;
        StringBuffer sb = new StringBuffer();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            userSolution = new UserSolution();
            sb.append('#').append(test_case).append(' ');
            userSolution.init(sc.nextInt());
            sb.append(userSolution.run()).append('\n');
        }
        System.out.println(sb);
    }
}

class UserSolution {

    long num;
    HashSet<Integer> checkValueSet = new HashSet<>();
    int count = 0;
    public void init(int num){
        this.num = num;
        for (int i=0; i<10; i++) {
            checkValueSet.add(i);
        }
    }

    public long run(){

        long tmp = num;
        while (checkValueSet.size() > 0) {
            count++;
            char[] inputChar = String.valueOf(tmp).toCharArray();
            for (int i=0; i<inputChar.length; i++) {
                if(checkValueSet.remove(inputChar[i] - '0')){
                    if (checkValueSet.size() == 0) return tmp;
                }
            }
            tmp += num;
        }
        return tmp;
    }
}