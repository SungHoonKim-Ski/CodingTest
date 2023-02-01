import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int count(int[] arr, int capacity){

        int count = 1;
        int endPos = arr[0];
        for(int i=1; i< arr.length; i++){
            if(arr[i] - endPos >= capacity){
                count++;
                endPos = arr[i];
            }
        }
        return count;
    }


    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int locCount = Integer.parseInt(st.nextToken());
        int horseCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] locs = new int[locCount];

        for(int i=0; i<locCount; i++){
            locs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(locs);

        int lt = 1;
        int rt = locs[locCount-1];

        int ans = 0;
        while (lt <= rt){
            int mid = (lt + rt) / 2;
            if(count(locs, mid) >= horseCount){
                ans = mid;
                lt = mid + 1;
            }else{
                rt = mid - 1;
            }
        }
        System.out.println(ans);
    }
}