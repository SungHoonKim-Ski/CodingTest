import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int N, M;
    static int[] Prices, Weights;


    static void input() throws IOException
    {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Prices = new int[N];
        for (int i = 0; i < N; i++) Prices[i] = Integer.parseInt(br.readLine());

        Weights = new int[M];
        for (int i = 0; i < M; i++) Weights[i] = Integer.parseInt(br.readLine());
    }

    static void pro() throws IOException
    {

        LinkedList<Integer> waitingCarQue = new LinkedList<>();

        int priceSum = 0;
        int inputCnt = M * 2;

        HashMap<Integer, Integer> hashMap = new HashMap<>(); // 차량이 주차된 위치를 찾기 위함

        while (inputCnt-- > 0) {

            int curCar = Integer.parseInt(br.readLine());

            if (curCar > 0) { // 차량이 들어가는 경우
                boolean hasPark = false;
                int i = 1;
                for (; i <= N; i++) {
                    if (!hashMap.containsValue(i)) {
                        hasPark = true;
                        break;
                    }
                }
                if (!hasPark) {
                    waitingCarQue.add(curCar);
                } else {
                    priceSum += Prices[i - 1] * Weights[curCar - 1];
                    hashMap.put(curCar, i);
                }
            } else { // 차량이 나가는 경우

                int exitPark = hashMap.get(-curCar);
                hashMap.remove(-curCar);

                if (!waitingCarQue.isEmpty()) {
                    int waitCar = waitingCarQue.poll();

                    priceSum += Prices[exitPark - 1] * Weights[waitCar - 1];
                    hashMap.put(waitCar, exitPark);
                }
            }
        }

        System.out.println(priceSum);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();

    }

}