import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int count = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        while (count > 0){
            String[] inputSplit = br.readLine().split(" ");
            if(inputSplit[0].equals("push")){
                stack.push(Integer.parseInt(inputSplit[1]));
            }else if(inputSplit[0].equals("pop")){
                sb.append(stack.pop());
                sb.append("\n");
            }else if(inputSplit[0].equals("size")){
                sb.append(stack.size());
                sb.append("\n");
            }else if(inputSplit[0].equals("empty")){
                sb.append(stack.empty());
                sb.append("\n");
            }else if(inputSplit[0].equals("top")){
                sb.append(stack.top());
                sb.append("\n");
            }
            count--;
        }
        System.out.println(sb.toString().trim());;
    }

    static public class Stack{
        int size = 0;
        int[] stack = new int[10001];
        int top;

        public void push(int input){
            size++;
            stack[size] = input;
            top = input;
        }

        public int top(){
            if(size == 0){
                top = -1;
            }
            return top;
        }

        public int pop(){
            int res = -1;
            if(size > 0){
                res = stack[size];
                size--;
                top = stack[size];
            }
            return res;
        }

        public int size(){
            return size;
        }

        public int empty(){
            if(size == 0){
                return 1;
            }else{
                return 0;
            }
        }

    }

}