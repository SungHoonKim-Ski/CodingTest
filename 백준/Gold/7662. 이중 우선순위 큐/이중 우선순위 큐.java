import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n;

    static void pro() throws IOException{

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        TreeSet<Integer> minTree = new TreeSet<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        TreeSet<Integer> maxTree = new TreeSet<>(Collections.reverseOrder());
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            int element = Integer.parseInt(st.nextToken());
            if (cmd == 'I') {

                hashMap.put(element, hashMap.getOrDefault(element, 0) + 1);
//                minTree.add(element);
                maxTree.add(element);

            } else {
                if (hashMap.size() == 0) continue;

                if (element == 1) { // 최대값 삭제
                    int peek = maxTree.first();
                    hashMap.put(peek, hashMap.get(peek) - 1);
                    if (hashMap.get(peek) == 0) {
                        hashMap.remove(maxTree.pollFirst());
                    }
                } else { // 최소값 삭제
                    int peek = maxTree.last();
                    hashMap.put(peek, hashMap.get(peek) - 1);
                    if (hashMap.get(peek) == 0) {
                        hashMap.remove(maxTree.pollLast());
                    }
                }
            }
        }
        if (maxTree.size() == 0) {
            sb.append("EMPTY");
        } else {
            sb.append(maxTree.first()).append(' ').append(maxTree.last());
        }
        sb.append('\n');
    }

    public static void main(String[] args) throws IOException{

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            pro();
        }
        System.out.println(sb);
    }

}