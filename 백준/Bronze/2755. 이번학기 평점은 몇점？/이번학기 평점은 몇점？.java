import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    static BufferedReader Br;
    static StringBuffer Sb;
    static StringTokenizer St;

    public static void main(String[] args) throws IOException {

        Br = new BufferedReader(new InputStreamReader(System.in));
        Sb = new StringBuffer();
        int n = Integer.parseInt(Br.readLine());
        float creditSum = 0;
        float calCreditSum = 0;
        for (int i=0; i<n; i++) {
            St = new StringTokenizer(Br.readLine());
            St.nextToken();
            float creditInt = Integer.parseInt(St.nextToken());
            creditSum += creditInt;
            
            String creditStr = St.nextToken();
            
            if (creditStr.equals("A+")) {
                calCreditSum += (4.3 * creditInt);
                continue;
            }
            if (creditStr.equals("A0")) {
                calCreditSum += (4.0 * creditInt);
                continue;
            }
            if (creditStr.equals("A-")) {
                calCreditSum += (3.7 * creditInt);
                continue;
            }
            if (creditStr.equals("B+")) {

                calCreditSum += (3.3 * creditInt);
                continue;
            }
            if (creditStr.equals("B0")) {

                calCreditSum += (3.0 * creditInt);
                continue;
            }
            if (creditStr.equals("B-")) {

                calCreditSum += (2.7 * creditInt);
                continue;
            }
            if (creditStr.equals("C+")) {

                calCreditSum += (2.3 * creditInt);
                continue;
            }
            if (creditStr.equals("C0")) {

                calCreditSum += (2.0 * creditInt);
                continue;
            }
            if (creditStr.equals("C-")) {

                calCreditSum += (1.7 * creditInt);
                continue;
            }
            if (creditStr.equals("D+")) {

                calCreditSum += (1.3 * creditInt);
                continue;
            }
            if (creditStr.equals("D0")) {

                calCreditSum += (1.0 * creditInt);
                continue;
            }
            if (creditStr.equals("D-")) {

                calCreditSum += (0.7 * creditInt);
                continue;
            }
        }

        double res = Math.round((calCreditSum / creditSum * 100)) / 100.0;
        System.out.println(String.format("%.2f", res));
    }
}