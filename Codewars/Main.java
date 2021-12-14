import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws Exception{

        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        int standardNum = sc.nextInt();

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<arrSize; i++){
            int compareNum = sc.nextInt();
            if(standardNum > compareNum){
                sb.append(compareNum + " ");
            }
        }

        System.out.println(sb.toString().trim());
        return;
    }
}
