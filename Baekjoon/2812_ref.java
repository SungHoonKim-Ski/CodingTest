import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String args[]){

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        String nk = sc.nextLine();
        String[] split = nk.split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int resLen = n - k;

        String input = sc.nextLine();

        Stack<Character> inputStack = new Stack<>();
        for(int i=0; i<input.length(); i++){
            if(!inputStack.isEmpty()){
                while(!inputStack.isEmpty() && k > 0 && inputStack.peek() < input.charAt(i)){
                    inputStack.pop();
                    --k;
                }
            }
            inputStack.push(input.charAt(i));
        }

        while(inputStack.size() != resLen){
            inputStack.pop();
        }

        Stack<Character> revStack = new Stack<>();
        while(!inputStack.isEmpty()){
            revStack.push(inputStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!revStack.isEmpty()){
            sb.append(revStack.pop());
        }

        System.out.println(sb);
        return;
    }
}