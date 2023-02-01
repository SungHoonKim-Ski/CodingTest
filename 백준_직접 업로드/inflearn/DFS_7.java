import java.util.*;

class Main{
    static int[] combiValueArr, isUsingNumber, resArr;
    static int inputNum, targetSum;
    static boolean flag=false;
    static int[][] combiArr=new int[11][11];
    public static int combi(int n, int r){
        if(combiArr[n][r]>0) return combiArr[n][r];
        if(n==r || r==0) return 1;
        else return combiArr[n][r]=combi(n-1, r-1)+combi(n-1, r);
    }

    public static void DFS(int Level, int sum){
        if(flag) return;
        if(Level==inputNum){
            if(sum==targetSum){
                StringBuffer sb = new StringBuffer();
                for(int x : resArr){
                    sb.append(x).append(' ');
                }
                System.out.println(sb);
                flag=true;
            }
        }
        else{
            for(int i=1; i<=inputNum; i++){
                if(isUsingNumber[i]==0){
                    isUsingNumber[i]=1;
                    resArr[Level]=i;
                    DFS(Level+1, sum+(resArr[Level] * combiValueArr[Level]));
                    isUsingNumber[i]=0;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        inputNum = sc.nextInt();
        targetSum = sc.nextInt();

        combiValueArr = new int[inputNum];
        resArr = new int[inputNum];
        isUsingNumber = new int[inputNum+1];
        for(int i=0; i<inputNum; i++){
            combiValueArr[i] = combi(inputNum-1, i);
        }
        DFS(0, 0);
    }
}