import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String args[]){

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        String nk = sc.nextLine();
        String[] split = nk.split(" ");
        int n = Integer.parseInt(split[0]); // type
        int k = Integer.parseInt(split[1]); // sum

        Stack<Integer> inputStack = new Stack<>();

        for(int i=0; i<n; i++){
            inputStack.push(Integer.parseInt(sc.nextLine()));
        }

        int count = 0;
        while(inputStack.size() >0 || k > 0){
            int type = inputStack.pop();
            int div = k / type;

            if(div > 0){
                count += div;
                k = k % type;
            }
        }

        System.out.println(count);

        return;
    }
}