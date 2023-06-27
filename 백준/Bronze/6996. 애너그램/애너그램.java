import java.util.*;
import java.util.Scanner;

public class Main {

    private static boolean solveAnagrams(String first, String second) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            char key = first.charAt(i);
            if (hashMap.containsKey(key)) {
                hashMap.replace(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }
        boolean isAnagrams = true;
        for (int i = 0; i < second.length(); i++) {
            char key = second.charAt(i);
            if (hashMap.containsKey(key)) {
                int value = hashMap.get(key);
                if (value == 1) hashMap.remove(key);
                else hashMap.replace(key, value - 1);
            } else {
                isAnagrams = false;
                break;
            }
        }
        if (!hashMap.isEmpty()) isAnagrams = false;
        return isAnagrams;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}
