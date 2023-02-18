import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main{

    static int[] arr;
    static int[] tmp;
    static long ans = 0;
    public static void main(String args[]) throws Exception{

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ans = 0;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tmp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, n-1);
        System.out.printf("%d\n", ans);
    }
    public static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) >> 1;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, end);
        }
    }
    public static void merge(int left, int right) {
        int mid = (left + right) >> 1;
        int leftIdx = left;
        int rightIdx = mid + 1;
        int idx = left;

        while (leftIdx <= mid && rightIdx <= right) {
            if(arr[leftIdx] <= arr[rightIdx]) {
                tmp[idx++] = arr[leftIdx++];
            } else {
                tmp[idx++] = arr[rightIdx++];
                ans += (mid - leftIdx + 1);
            }
        }
        while(leftIdx <= mid) {
            tmp[idx++] = arr[leftIdx++];
        }

        while(rightIdx <= right) {
            tmp[idx++] = arr[rightIdx++];
        }

        for(int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }
}