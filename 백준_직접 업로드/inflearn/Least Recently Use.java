import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cacheSize = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        List<Integer> cache = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<count; i++){
            int input = Integer.parseInt(st.nextToken());
            if (cache.contains(input)) {
                cache.remove((Object) input);
            }
            else if (cache.size() == cacheSize){
                cache.remove(0);
            }
            cache.add(input);
        }

        for(int i=cacheSize-1; i>=0; i--){
            sb.append(cache.get(i)).append(' ');

        }

        System.out.println(sb);
    }
}