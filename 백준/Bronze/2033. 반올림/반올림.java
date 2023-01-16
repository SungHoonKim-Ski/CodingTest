import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        char[] num = br.readLine().toCharArray();

        boolean carry = false;
        for (int i= num.length-1; i >= 0; i--) {
            if (carry) num[i]++;
            carry = false;
            if (num[i] > '4') {
                carry = true;
            }
            if (i != num.length-1) sb.append('0');
        }
        if (num[0] > '9') sb.append("01");
        else sb.append(num[0]);
        System.out.println(sb.reverse());
    }

}