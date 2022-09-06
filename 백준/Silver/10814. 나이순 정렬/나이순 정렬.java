import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br;
    private static StringBuffer sb;

    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        int size = Integer.parseInt(br.readLine());

        User[] users = new User[size];
        for(int i=0; i<size; i++){
            String[] splitArr = br.readLine().split(" ");
            users[i] = new User(i,Integer.parseInt(splitArr[0]), splitArr[1]);
        }

        Arrays.sort(users);

        for(User user : users){
            sb.append(user.print());
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);

        br.close();
        sb.setLength(0);
    }

    public static class User implements Comparable<User>{

        int index;
        int age;
        String name;

        public User(int index, int age, String name){
            this.index = index;
            this.age = age;
            this.name = name;
        }

        public String print(){
            return age + " " + name + "\n";
        }

        @Override
        public int compareTo(User o) {
            if(o.age == this.age){
                return this.index - o.index;
            }else{
                return this.age - o.age;
            }
        }
    }

}