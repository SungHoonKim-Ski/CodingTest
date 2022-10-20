import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static StringBuffer sb;

    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        int holeCount = Integer.parseInt(br.readLine());
        for(int i=0; i<holeCount; i++){
            char[] revOrDel = br.readLine().toCharArray();
            int count = Integer.parseInt(br.readLine());
            String[] inputIntArray = br.readLine().split(",");
            inputIntArray[0] = inputIntArray[0].replace("[", "");
            inputIntArray[inputIntArray.length-1] = inputIntArray[inputIntArray.length-1].replace("]", "");

            Deque<Integer> intArrDeque = new LinkedList();
            for(int j=0; j<count; j++){
                intArrDeque.addLast(Integer.parseInt(inputIntArray[j]));
            }

            reverseORExcept(intArrDeque, revOrDel);
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
        return;
    }

    public static void reverseORExcept(Deque<Integer> intArrDeque, char[] revORDel){

        boolean isASC = true;
        for(int i=0; i<revORDel.length; i++){
            if(revORDel[i] == 'R'){ // Reverse
                isASC = !isASC;
            }else{ // Del
                if(intArrDeque.size() == 0){
                    intArrDeque = null;
                    break;
                }
                if(isASC){
                    intArrDeque.removeFirst();
                }else{
                    intArrDeque.removeLast();
                }
            }
        }
        printArray(intArrDeque, isASC);
    }

    public static void printArray(Deque<Integer> intArrDeque, boolean isASC){
        if(intArrDeque == null){
            sb.append("error");
        }else{
            sb.append("[");
            if(intArrDeque.size() > 0){
                if(isASC){
                    while (intArrDeque.size() > 0){
                        sb.append(intArrDeque.pollFirst() + ",");
                    }
                }else{
                    while (intArrDeque.size() > 0){
                        sb.append(intArrDeque.pollLast() + ",");
                    }
                }
                sb.setLength(sb.length()-1);
            }
            sb.append("]");
        }
        sb.append("\n");
    }
}
