import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] binaryInput = Integer.toBinaryString(Integer.parseInt(br.readLine())).toCharArray();
        int res = 0;
        for (int i=0; i< binaryInput.length;i++) {
            if (binaryInput[i] == '1') res++;
        }

        System.out.println(res);
    }
}