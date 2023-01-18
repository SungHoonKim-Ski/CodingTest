import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double[] inputFruit = new double[] {Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())};
        st = new StringTokenizer(br.readLine());
        double[] fruitRatio = new double[] {Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())};

        double minRatio = 20;
        for (int i=0; i<3; i++) {
            minRatio = Math.min(inputFruit[i] / fruitRatio[i], minRatio);
        }

        for (int i=0; i<3; i++) {
            sb.append(inputFruit[i]- (fruitRatio[i] * minRatio)).append(' ');
        }

        System.out.println(sb);
    }

}