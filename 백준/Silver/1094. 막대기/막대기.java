import java.util.Scanner;

class Main
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        char[] binaryInput = Integer.toBinaryString(T).toCharArray();
        int res = 0;
        for (int i=0; i< binaryInput.length;i++) {
            if (binaryInput[i] == '1') res++;
        }

        System.out.println(res);
    }
}