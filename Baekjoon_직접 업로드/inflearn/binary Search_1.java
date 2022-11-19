import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer((br.readLine()), " ");
        int[] arr = new int[count];
        for(int i=0; i<count; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length-1;
        int mid = 0;
        while (start <= end){
            mid = (start + end) / 2;
            if(target == arr[mid]){
                System.out.println(mid + 1);
                break;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else if(target < arr[mid]){
                end = mid - 1;
            }
        }
    }
}