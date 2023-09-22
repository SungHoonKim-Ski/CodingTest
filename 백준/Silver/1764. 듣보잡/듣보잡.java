import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String[] inputSplit = br.readLine().split(" ");

        int cantListenCount = Integer.parseInt(inputSplit[0]);
        int cantSeeCount = Integer.parseInt(inputSplit[1]);

        HashSet<String> cantListenSet = new HashSet<>();
        List<String> cantListenSeeList = new ArrayList<>();

        for(int i=0; i<cantListenCount; i++){
            cantListenSet.add(br.readLine());
        }

        int cantListenSeeCount = 0;
        for(int i=0; i<cantSeeCount; i++){
            String cantSee = br.readLine();
            if(cantListenSet.contains(cantSee)){
                cantListenSeeList.add(cantSee);
                cantListenSeeCount++;
            }
        }
        Collections.sort(cantListenSeeList);

        sb.append(cantListenSeeCount);
        sb.append("\n");
        for(String cantListenSee : cantListenSeeList){
            sb.append(cantListenSee);
            sb.append("\n");
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
        br.close();
        sb.setLength(0);
    }

}