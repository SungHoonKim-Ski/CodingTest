import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuffer sb = new StringBuffer();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append('#').append(test_case).append(' ');
            int N = sc.nextInt(); // 수열의 길이
            int M = sc.nextInt(); // 추가 횟수
            int L = sc.nextInt(); // 출력할 인덱스 번호
            List<Integer> list = new LinkedList<>();
            for (int i=0; i<N; i++) {
                list.add(i, sc.nextInt());
            }
            for (int i=0; i<M; i++) {
                char command = sc.next().charAt(0);
                int location = sc.nextInt();
                if (command == 'I') {
                    list.add(location, sc.nextInt());
                }else if (command == 'D') {
                    list.remove(location);
                }else {
                    list.set(location, sc.nextInt());
                }
            }
            if (list.size() >= L) {
                sb.append(list.get(L));
            }else {
                sb.append(-1);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

