import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br;
    private static StringBuffer sb;

    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        int size = Integer.parseInt(br.readLine());
        HashSet<String> wordSet = new HashSet();
        for(int i=0; i<size; i++){
            wordSet.add(br.readLine());
        }

        Word[] words = new Word[wordSet.size()];
        Iterator iter = wordSet.iterator();

        int i=0;
        while (iter.hasNext()){
            words[i] = new Word(iter.next().toString());
            i++;
        }

        Arrays.sort(words);

        for(Word word : words){
            sb.append(word.print());
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);

        br.close();
        sb.setLength(0);
    }

    public static class Word implements Comparable<Word>{
        String word;

        public Word(String word){
            this.word = word;
        }

        public String print(){
            return word;
        }

        @Override
        public int compareTo(Word o) {
            if(this.word.length() < o.word.length()){
                return -1;
            }else if(this.word.length() > o.word.length()){
                return 1;
            }else{
                return this.word.compareTo(o.word);
            }
        }
    }

}