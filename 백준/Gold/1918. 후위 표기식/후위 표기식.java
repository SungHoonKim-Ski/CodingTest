import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;
    static char[] InputCharArr;



    static void input() throws IOException
    {
        InputCharArr = br.readLine().toCharArray();
    }

    static void pro()
    {
        Deque<Character> operatorStack = new LinkedList<>();

        for (int i = 0; i < InputCharArr.length; i++) {
            switch (InputCharArr[i]) {
                case '+':
                case '-':
                    if (!operatorStack.isEmpty()) {
                        while (operatorStack.size() != 0
                                && (operatorStack.peek() != '/' || operatorStack.peek() != '*')
                                && operatorStack.peek() != '(') {
                                sb.append(operatorStack.poll());
                        }
                    }
                    operatorStack.push(InputCharArr[i]);
                    break;
                case '*':
                case '/':
                    if (!operatorStack.isEmpty()) {
                        while (operatorStack.size() != 0
                                && (operatorStack.peek() != '+' && operatorStack.peek() != '-')
                                && operatorStack.peek() != '(') {
                            sb.append(operatorStack.poll());
                        }
                    }
                    operatorStack.push(InputCharArr[i]);
                    break;
                case  '(':
                    operatorStack.push(InputCharArr[i]);
                    break;
                case ')':
                    while (operatorStack.peek() != '(')
                        sb.append(operatorStack.poll());
                    operatorStack.poll(); // ( 제거
                    break;
                default: // alphabet
                    sb.append(InputCharArr[i]);
            }
        }
        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek() == '(') operatorStack.poll();
            sb.append(operatorStack.poll());
        }


        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();

    }

}