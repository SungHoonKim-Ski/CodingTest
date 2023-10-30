import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m;
    static ArrayList<Integer>[] parentChildGraph;
    static int[] indeg; // 진입차수
    static double[] power; // 힘 float x

    static HashMap<String, Integer> nameIdxMap;
    static HashSet<String> candiSet;
    static String king;
    static int nameIdx;


    static void input() throws IOException {

        nameIdxMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        king = br.readLine();
        nameIdxMap.put(king, nameIdx++);

        parentChildGraph = new ArrayList[n * 3 + 1];
        power = new double[n * 3 + 1];
        indeg = new int[n * 3 + 1];

        for (int i = 0; i <= n * 3; i++) {
            parentChildGraph[i] = new ArrayList<>();
        }
        // 최대 정점 개수는 3n개정도 될듯..

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String child = st.nextToken();
            String parent1 = st.nextToken();
            String parent2 = st.nextToken();

            int childIdx, parent1Idx, parent2Idx; // 이름을 인덱스로 변경시켜서 입력

            childIdx = parent1Idx = parent2Idx = -1;

            if (nameIdxMap.containsKey(child)) {
                childIdx = nameIdxMap.get(child); // 앞에 나온적이 있다면 해당 인덱스를 가져오고
            }
            else {
                // 나온적이 없다면 이름을 숫자로 부를 별칭을 만들고
                nameIdxMap.put(child, nameIdx);  // 이를 이름 - 별칭 map에 저장
                childIdx = nameIdx;
                nameIdx++;
            }

            if (nameIdxMap.containsKey(parent1)) {
                parent1Idx = nameIdxMap.get(parent1);
            }
            else {
                nameIdxMap.put(parent1, nameIdx);
                parent1Idx = nameIdx;
                nameIdx++;
            }

            if (nameIdxMap.containsKey(parent2)) {
                parent2Idx = nameIdxMap.get(parent2);
            }
            else {
                nameIdxMap.put(parent2, nameIdx);
                parent2Idx = nameIdx;
                nameIdx++;
            }
            parentChildGraph[parent1Idx].add(childIdx);
            parentChildGraph[parent2Idx].add(childIdx);

            indeg[childIdx] += 2; // 자식 기준으로 부모가 두 명이므로
            // 진입 차수가 2라고 볼 수 있음
        }

        candiSet = new HashSet<>();
        while (m-- > 0) candiSet.add(br.readLine()); // 나중에 후보로 들어오는 이름들

    }

    static void pro() {

        Deque<Integer> que = new ArrayDeque<>();
        power[0] = 1f;
        
        for (int i = 0; i < nameIdx; i++) {
            if (indeg[i] == 0) que.add(i);
            // 진입차수가 0인 부모들을 모두 add
            // 위상정렬 방식
        }

        while (!que.isEmpty()) {

            int curIdx = que.poll();

            double curPower = power[curIdx]; // 현재 나의 힘

            for (int nextIdx : parentChildGraph[curIdx]) {
                if (indeg[nextIdx] == 0) continue;

                power[nextIdx] += curPower; // 내 힘을 자식에게 물려준다
                indeg[nextIdx]--; // 자식의 진입차수 --

                if (indeg[nextIdx] == 0) { // 만약 두 부모에게 모두 물려받았다면
                    power[nextIdx] /= 2; // 나의 힘을 2로 나누고
                    que.add(nextIdx); // que에 add
                }
            }
        }

        double maxPower = -1; // 최악의 경우 0이므로 최소값을 -1로 잡음
        String maxName = "";

        for (String cand : candiSet) {
            int candIdx = nameIdxMap.getOrDefault(cand, -1);
            if (candIdx == -1) continue; // 앞에 계산에서 나오지 않았던 이름이 후보군에 나올 수 있음
            // 이 부분 예외처리

            double candPower = power[candIdx];
            if (maxPower < candPower) {
                maxPower = candPower;
                maxName = cand;
            }
        }

        System.out.println(maxName);

    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}


