import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        Stack<Integer> stack = new Stack<>();
        int count = Integer.parseInt(br.readLine());
        int top = 0;

        while (count-- > 0){
            int target = Integer.parseInt(br.readLine());
            if(target > top){
                for(int i = top + 1; i<= target; i++){
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                top = target;
            }else if(stack.peek() != target){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}
