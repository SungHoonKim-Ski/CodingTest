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

        int input;
        int contestCount = 0;

        while((input =Integer.parseInt(br.readLine())) != 0){

            User users[] = new User[input];

            contestCount++;
            sb.append("CONTEST " + contestCount + "\n");
            for(int i=0; i<input; i++){
                users[i] = new User(br.readLine().split(" "));
            }

            Arrays.sort(users);

            int prevSumScore = 0;
            int prevGeometryMean = 0;
            int prevRank = 1;
            for(int i=1; i<=input; i++){
                prevRank = users[i-1].print(prevSumScore, prevRank, prevGeometryMean, i);
                prevSumScore = users[i-1].sumScore;
                prevGeometryMean = users[i-1].geometricMean;
            }
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }

    private static class User implements Comparable<User>{
        int sumScore = 0;
        String name;
        int[] scores = new int[7];
        int countValScore = 0;
        int geometricMean = 0;

        public User(String[] splitArr){
            name = splitArr[0];
            double calGeometricMean = 1;
            for(int i=1; i<8; i++){
                int score = Integer.parseInt(splitArr[i]);
                if(score != 0){
                    scores[i-1] = score;
                    countValScore++;
                    sumScore += score;
                    calGeometricMean *= score;
                }
            }
            if(countValScore > 0){
                geometricMean = (int)Math.round(Math.pow(calGeometricMean, 1.0/countValScore));
            }
        }
        public int print(int prevSumScore, int prevRank, int prevGeometryMean, int printCount){

            int rank = (prevSumScore == this.sumScore) && (prevGeometryMean == this.geometricMean) ? prevRank : printCount;

            sb.append(String.format("%02d ", rank));
            sb.append(String.format("%-10s ", name));
            sb.append(String.format("%1d ", countValScore));
            sb.append(String.format("%4d ", sumScore));
            sb.append(String.format("%3d ", geometricMean));
            for(int i=0; i<scores.length; i++){
                sb.append(String.format("%3d ", scores[i]));
            }
            sb.append("\n");
            return rank;
        }
        @Override
        public int compareTo(User o) {
            if(this. sumScore == o.sumScore){
                if(this.geometricMean == o.geometricMean){
                    return this.name.compareTo(o.name);
                }else{
                    return this.geometricMean - o.geometricMean;
                }
            }else{
                return o.sumScore - this.sumScore;
            }
        }
    }

}