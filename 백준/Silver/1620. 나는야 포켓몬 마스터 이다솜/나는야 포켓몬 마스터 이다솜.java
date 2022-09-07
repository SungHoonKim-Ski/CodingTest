import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String[] inputSplit = br.readLine().split(" ");
        int N = Integer.parseInt(inputSplit[0]); // monsterCount

        HashMap<String, Integer> pokemonMap = new HashMap<>();
        String[] pokemonArr = new String[N+1];

        for(int i=1; i<=N; i++){
            String pokemon = br.readLine();
            pokemonArr[i] = pokemon;
            pokemonMap.put(pokemon, i);
        }

        int M = Integer.parseInt(inputSplit[1]); // quizCount
        for(int i=0; i<M; i++){
            String quiz = br.readLine();
            String res;
            try{
                 res = pokemonArr[Integer.parseInt(quiz)];
            }catch (NumberFormatException e){
                res = pokemonMap.get(quiz).toString();
            }
            sb.append(res + "\n");
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
        br.close();
        sb.setLength(0);
    }

}