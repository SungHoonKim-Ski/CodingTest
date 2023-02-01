import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splitMinus = br.readLine().split("-");

        String[][] splitPlus = new String[splitMinus.length][];
        int[] sumSplitMinus = new int[splitMinus.length];

        for(int i=0; i< splitPlus.length; i++){
            splitPlus[i] = splitMinus[i].split("\\+");
            for(int j=0; j<splitPlus[i].length; j++){
                sumSplitMinus[i] += Integer.parseInt(splitPlus[i][j]);
            }
        }

        int minSum = sumSplitMinus[0];

        for(int i=1; i<sumSplitMinus.length; i++){
            minSum -= sumSplitMinus[i];
        }


        System.out.println(minSum);
        return;
    }
}