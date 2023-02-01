import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws Exception{

        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNextLine()){
            String[] split = sc.nextLine().split(" ");
            if(Integer.parseInt(split[1]) > 9 || Integer.parseInt(split[0]) < 1) {
                System.out.println("error");
                return;
            }
            System.out.println(Integer.parseInt(split[0]) + Integer.parseInt(split[1]));
        }
        
        return;
    }
}
