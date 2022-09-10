import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int num = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for(int i=1; i<=num; i++){
            deque.addLast(i);
        }

        while(true){
            if(deque.size() == 1)
                break;
            deque.removeFirst();
            if(deque.size() == 1)
                break;
            deque.addLast(deque.pollFirst());
        }
        System.out.println(deque.poll());
    }

}