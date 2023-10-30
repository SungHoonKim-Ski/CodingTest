import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m;
    static ArrayList<Integer>[] parentChildGraph, childParentGraph;
    static int[] indeg;
    static double[] power;

    static boolean[] visit;

    static HashMap<Integer, String> idxNameMap;
    static HashMap<String, Integer> nameIdxMap;
    static HashSet<String> candiSet;
    static String king;
    static int nameIdx;


    static void input() throws IOException {

        idxNameMap = new HashMap<>();
        nameIdxMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        king = br.readLine();
        nameIdxMap.put(king, nameIdx);
        idxNameMap.put(nameIdx++, king);

        parentChildGraph = new ArrayList[n * 3 + 1];
        childParentGraph = new ArrayList[n * 3 + 1];
        power = new double[n * 3 + 1];
        visit = new boolean[n * 3 + 1];
        indeg = new int[n * 3 + 1];

        for (int i = 0; i <= n * 3; i++) {
            parentChildGraph[i] = new ArrayList<>();
            childParentGraph[i] = new ArrayList<>();
        }
        // 최대 개수는 3n개?

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String child = st.nextToken();
            String parent1 = st.nextToken();
            String parent2 = st.nextToken();

            int childIdx, parent1Idx, parent2Idx; // 이름을 인덱스로 변경시켜서 입력

            childIdx = parent1Idx = parent2Idx = -1;

            if (nameIdxMap.containsKey(child)) {
                childIdx = nameIdxMap.get(child); // 앞에 나온적이 있다면
            }
            else {
                nameIdxMap.put(child, nameIdx);
                idxNameMap.put(nameIdx, child);
                childIdx = nameIdx;
                nameIdx++;
            }

            if (nameIdxMap.containsKey(parent1)) {
                parent1Idx = nameIdxMap.get(parent1);
            }
            else {
                nameIdxMap.put(parent1, nameIdx);
                idxNameMap.put(nameIdx, parent1);
                parent1Idx = nameIdx;
                nameIdx++;
            }

            if (nameIdxMap.containsKey(parent2)) {
                parent2Idx = nameIdxMap.get(parent2);
            }
            else {
                nameIdxMap.put(parent2, nameIdx);
                idxNameMap.put(nameIdx, parent2);
                parent2Idx = nameIdx;
                nameIdx++;
            }
            parentChildGraph[parent1Idx].add(childIdx);
            parentChildGraph[parent2Idx].add(childIdx);
            childParentGraph[childIdx].add(parent1Idx);
            childParentGraph[childIdx].add(parent2Idx);

            indeg[childIdx] += 2;
        }

        candiSet = new HashSet<>();
        while (m-- > 0) candiSet.add(br.readLine());

    }

    static void pro() {

        Deque<Integer> que = new ArrayDeque<>();
        power[0] = 1f;
        
        for (int i = 0; i < nameIdx; i++) {
            if (indeg[i] == 0) que.add(i);
        }

        while (!que.isEmpty()) {

            int curIdx = que.poll();

            double curPower = power[curIdx];

            for (int nextIdx : parentChildGraph[curIdx]) {
                if (indeg[nextIdx] == 0) continue;

                power[nextIdx] += curPower;
                indeg[nextIdx]--;

                if (indeg[nextIdx] == 0) {
                    power[nextIdx] /= 2;
                    que.add(nextIdx);
                }
            }
        }

        double maxPower = -1;
        String maxName = "";

        for (String cand : candiSet) {
            int candIdx = nameIdxMap.getOrDefault(cand, -1);
            if (candIdx == -1) continue;
            double candPower = power[candIdx];
            if (maxPower < candPower) {
                maxPower = candPower;
                maxName = cand;
            }
        }
//        for (int i = 0; i < power.length; i++) {
//            sb.append(idxNameMap.get(i)).append(' ');
//            sb.append(power[i]).append(' ');
//            sb.append('\n');
//
//        }
//        System.out.println(sb);

        System.out.println(maxName);

    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}


