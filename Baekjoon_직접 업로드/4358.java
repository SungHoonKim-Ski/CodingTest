import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> treeMap = new HashMap<>();

        int count = 0;
        while(sc.hasNextLine()){
            String input = sc.nextLine();
            if(!treeMap.containsKey(input)){
                treeMap.put(input, 1);
            }else{
                int oldValue = treeMap.get(input);
                treeMap.replace(input, oldValue, ++oldValue);
            }
            count++;
        }

        String treeArr[] = treeMap.keySet().toArray(new String[0]);
        Arrays.sort(treeArr);

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<treeArr.length; i++){

            float ratio = treeMap.get(treeArr[i]) / (float)count * 100;
            sb.append(treeArr[i]);
            sb.append(" ");
            sb.append(String.format("%.4f", ratio));

            System.out.println(sb.toString());
            sb.delete(0, sb.length());
        }

        return;
    }
}

