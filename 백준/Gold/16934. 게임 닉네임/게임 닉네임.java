import java.io.*;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer searchSb = new StringBuffer();
    static StringBuffer printSb = new StringBuffer();
    static StringTokenizer st;
    static int N;
    static String[] InputStrArr;
    
    static HashMap<String, Integer> PrintCntMap;
    static HashSet<String> ElementSet; 

    static void input() throws Exception{

        N = Integer.parseInt(br.readLine());
        InputStrArr = new String[N];
        for (int i = 0; i < N; i++) {
            InputStrArr[i] = br.readLine();
        }
        
        PrintCntMap = new HashMap<>();
        ElementSet = new HashSet<>();  
    }

    static void pro() {

        for (int i = 0; i < N; i++) {
            
            String curStr = InputStrArr[i];
            
            if (PrintCntMap.containsKey(curStr)) {
            	int cnt = PrintCntMap.get(curStr) + 1;
            	PrintCntMap.replace(curStr,  cnt);
            	printSb.append(curStr).append(cnt).append('\n');
            } else {
            	PrintCntMap.put(curStr,  1);
            	search(curStr, 0, true);
            	printSb.append('\n');
            	searchSb.setLength(0);
            }
            
        }
    }

    static void search(String str, int depth, boolean needPrint) {

    	
        if (str.length() == depth) return;
        
        char c = str.charAt(depth);
        
        if (needPrint) printSb.append(c);
        searchSb.append(c);
        if (!ElementSet.contains(searchSb.toString())) {
        	ElementSet.add(searchSb.toString());
        	needPrint = false;
        }
        search(str, depth + 1, needPrint);
    }


    public static void main(String[] args) throws Exception{

        input();
        pro();

        System.out.println(printSb);
    }

}