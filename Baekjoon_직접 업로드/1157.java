import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {

    public static void main(String args[]) throws IOException { //1157
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine().toUpperCase(Locale.ROOT);
        HashMap<Character, Integer> charMap = new HashMap<>();

        for(int i=0; i<inputStr.length(); i++){
            char inputChar = inputStr.charAt(i);
            if(charMap.containsKey(inputChar)){
                charMap.replace(inputChar, charMap.get(inputChar), charMap.get(inputChar)+1);
            }else{
                charMap.put(inputChar, 1);
            }
        }
        int maxValue = 0;
        char maxChar = ' ';
        for(Map.Entry<Character, Integer> elem : charMap.entrySet()){
            if(maxValue < elem.getValue()){
                maxValue = elem.getValue();
                maxChar = elem.getKey();

            }else if(maxValue == elem.getValue()){
                maxChar = '?';
            }
        }

        System.out.println(maxChar);
        return;
    }

}
