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
        Queue queue = new LinkedList();
        int back = -1;
        while (count > 0){
            String[] inputSplit = br.readLine().split(" ");
            if(inputSplit[0].equals("push")){
                queue.add(Integer.parseInt(inputSplit[1]));
                back = Integer.parseInt(inputSplit[1]);
            }else if(inputSplit[0].equals("pop")){
                if(queue.size() > 0){
                    sb.append(queue.poll());
                    if(queue.isEmpty())
                        back = -1;
                }else{
                    sb.append("-1");
                }
                sb.append("\n");
            }else if(inputSplit[0].equals("size")){
                sb.append(queue.size());
                sb.append("\n");
            }else if(inputSplit[0].equals("empty")){
                if(queue.size() > 0){
                    sb.append("0");
                }else{
                    sb.append("1");
                }
                sb.append("\n");
            }else if(inputSplit[0].equals("front")){
                if(queue.size() > 0){
                    sb.append(queue.peek());
                }else{
                    sb.append("-1");
                }
                sb.append("\n");
            }else if(inputSplit[0].equals("back")){
                sb.append(back);
                sb.append("\n");
            }
            count--;
        }
        System.out.println(sb.toString().trim());;
    }

}