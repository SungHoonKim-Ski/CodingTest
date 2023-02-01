import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        int[] a = new int[1000001];

        for(int i=2;i<=1000000;i++) {
            a[i] = i;
        }

        for(int i=2;i<=1000000;i++) {
            if(a[i]==0) {
                continue;
            }
            for(int j=i+i;j<=1000000; j+=i) {
                a[j] = 0;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != "0"){
            int num = Integer.parseInt(input);
            if(num < 6){
                break;
            }
            boolean isExist = false;
            for(int i=3; i<num; i+=2){

                if(a[i] + a[num - i] == num){
                    isExist = true;
                    StringBuffer sb = new StringBuffer();
                    sb.append(num);
                    sb.append(" = ");
                    sb.append(a[i]);
                    sb.append(" + ");
                    sb.append(a[num - i]);
                    System.out.println(sb);
                }

                if (isExist) {
                    break;
                }
            }
            if(!isExist){
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}

