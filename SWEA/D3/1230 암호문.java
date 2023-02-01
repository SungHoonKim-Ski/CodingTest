import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        StringBuffer sb = new StringBuffer();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append('#').append(test_case).append(' ');
            int length = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            while (length > 0) {
                list.add(sc.nextInt());
                length--;
            }
            int inputLength = sc.nextInt();
            while (inputLength > 0) {
                char command = sc.next().charAt(0);
                if (command == 'I') { // insert
                    int index = sc.nextInt();
                    int count = sc.nextInt();
                    List<Integer> tmpList = new ArrayList<>();
                    for (int i=0; i<count; i++) {
                        tmpList.add(sc.nextInt());
                    }
                    list.addAll(index, tmpList);
                }else if (command == 'D'){ // Delete
                    int index = sc.nextInt();
                    int count = sc.nextInt();
                    while (count > 0) {
                        list.remove(index);
                        count--;
                    }
                }else { // Add
                    int count = sc.nextInt();
                    while (count > 0) {
                        list.add(sc.nextInt());
                        count--;
                    }
                }
                inputLength--;
            }
            for (int i=0; i<10; i++) {
                sb.append(list.get(i)).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

