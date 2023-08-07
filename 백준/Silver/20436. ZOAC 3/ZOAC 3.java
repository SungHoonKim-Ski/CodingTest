import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static HashMap<Character, int[]> LeftHandMap;
    static HashMap<Character, int[]> RightHandMap;
    static int[] LeftHandLoc, RightHandLoc;

    static char[] InputCharArr;

    static void init() {

        LeftHandMap = new HashMap<>();
        LeftHandMap.put('q', new int[] {0, 0});
        LeftHandMap.put('w', new int[] {0, 1});
        LeftHandMap.put('e', new int[] {0, 2});
        LeftHandMap.put('r', new int[] {0, 3});
        LeftHandMap.put('t', new int[] {0, 4});

        LeftHandMap.put('a', new int[] {1, 0});
        LeftHandMap.put('s', new int[] {1, 1});
        LeftHandMap.put('d', new int[] {1, 2});
        LeftHandMap.put('f', new int[] {1, 3});
        LeftHandMap.put('g', new int[] {1, 4});

        LeftHandMap.put('z', new int[] {2, 0});
        LeftHandMap.put('x', new int[] {2, 1});
        LeftHandMap.put('c', new int[] {2, 2});
        LeftHandMap.put('v', new int[] {2, 3});


        RightHandMap = new HashMap<>();

        RightHandMap.put('y', new int[] {0, 5});
        RightHandMap.put('u', new int[] {0, 6});
        RightHandMap.put('i', new int[] {0, 7});
        RightHandMap.put('o', new int[] {0, 8});
        RightHandMap.put('p', new int[] {0, 9});


        RightHandMap.put('h', new int[] {1, 5});
        RightHandMap.put('j', new int[] {1, 6});
        RightHandMap.put('k', new int[] {1, 7});
        RightHandMap.put('l', new int[] {1, 8});

        RightHandMap.put('b', new int[] {2, 4});
        RightHandMap.put('n', new int[] {2, 5});
        RightHandMap.put('m', new int[] {2, 6});

        // 힘드네요..
    }
    static void input() throws IOException
    {
        char[] startStr = br.readLine().toCharArray();
        if (LeftHandMap.containsKey(startStr[0])) {
            LeftHandLoc = LeftHandMap.get(startStr[0]);
        } else {
            RightHandLoc = RightHandMap.get(startStr[0]);
        }

        if (LeftHandMap.containsKey(startStr[2])) {
            LeftHandLoc = LeftHandMap.get(startStr[2]);
        } else {
            RightHandLoc = RightHandMap.get(startStr[2]);
        }

        InputCharArr = br.readLine().toCharArray();
    }

    static void pro()
    {
        int time = 0;

        for (int i = 0; i < InputCharArr.length; i++) {

            int[] nextLoc;
            if (LeftHandMap.containsKey(InputCharArr[i])) {
                nextLoc = LeftHandMap.get(InputCharArr[i]);
                time += calDist(LeftHandLoc, nextLoc);
                LeftHandLoc = nextLoc;
            } else {
                nextLoc = RightHandMap.get(InputCharArr[i]);
                time += calDist(RightHandLoc, nextLoc);
                RightHandLoc = nextLoc;
            }
            time++; // 누르는데 1초
        }
        System.out.println(time);
    }

    static int calDist(int[] loc1, int[] loc2) {

        int res = 0;
        res += Math.abs(loc1[0] - loc2[0]);
        res += Math.abs(loc1[1] - loc2[1]);
        return res;
    }



    public static void main(String[] args) throws Exception{

        init();
        input();
        pro();
    }

}