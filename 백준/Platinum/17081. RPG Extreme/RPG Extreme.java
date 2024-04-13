import java.io.*;
import java.util.*;

class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int TURN = 0, LV = 1, HP = 20, ATT = 2, DEF = 2, EXP = 0, MAXHP = 20;
    static int[] curLoc, startLoc;
    static char[][] map;
    static Monster[][] monsterArr;
    static Event[][] eventArr;
    static int n, m, boxCnt, monsterCnt;
    static char[] moveArr;
    static HashSet<String> curAccessorySet;
    static int curWeapon = 0, curAmor = 0;

    static class Monster{
        int w; // 공격력
        int a; // 방어력
        int h; // 체력
        int e; // 경험치

        String name;

        Monster(int _w, int _a, int _h, int _e, String _name) {
            w = _w;
            a = _a;
            h = _h;
            e = _e;
            name = _name;
        }

        Monster(Monster monster) {
            w = monster.w;
            a = monster.a;
            h = monster.h;
            e = monster.e;
            name = monster.name;
        }
    }

    static class Event {
        boolean isAccessory;
        String type;
        int option;

        Event(String _type, int _option) {
            isAccessory = false;
            option = _option;
            type = _type;
        }

        Event(String _type) {
            isAccessory = true;
            type = _type;
            option = -1;
        }
    }
    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            char[] charArr = br.readLine().toCharArray();
            for (int j = 1, k = 0; j <= m; j++, k++) {
                map[i][j] = charArr[k];

                switch (map[i][j]) {
                    case '.': // 빈 칸
                    case '#':
                        break;
                    case 'B': // 아이템 상자(열리지 않을 수 있음)
                        boxCnt++;
                        break;
                    case '@': // 주인공
                        map[i][j] = '.';
                        startLoc = new int[] {i, j};
                        curLoc = new int[] {i, j};
                        break;
                    case '&': // 몬스터
                        monsterCnt++;
                        break;
                    // case 'M': // 보스 몬스터

                }
            }
        }

        moveArr = br.readLine().toCharArray();

        monsterArr = new Monster[n + 1][m + 1];
        eventArr = new Event[n + 1][m + 1];

        for (int i = 0; i <= monsterCnt; i++) { // 보스 포함이므로 <=

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            String monsterName = st.nextToken();
            int w, a, h, e;
            w = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            monsterArr[r][c] = new Monster(w, a, h, e, monsterName);
        }

        for (int i = 0; i < boxCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            String type = st.nextToken();

            if (type.equals("O")) { // 악세서리의 경우
                eventArr[r][c] = new Event(st.nextToken());
            } else { // 아닌 경우
                eventArr[r][c] = new Event(type, Integer.parseInt(st.nextToken()));
            }
        }

        curAccessorySet = new HashSet<>();
    }

    public static void pro() {

        map[startLoc[0]][startLoc[1]] = '.';

        int[] dy = {0, -1, 0, 1};
        int[] dx = {1, 0, -1, 0};
        // R, U, L, D

        HashMap<Character, Integer> posMap = new HashMap<>();
        posMap.put('R', 0);
        posMap.put('U', 1);
        posMap.put('L', 2);
        posMap.put('D', 3);

        String log = "";
        boolean isBossKilled = false;

        for (char move : moveArr) {

            int moveIdx = posMap.get(move);
            int ny = curLoc[0] + dy[moveIdx];
            int nx = curLoc[1] + dx[moveIdx];

            if (ny != 0 && nx != 0 && ny <= n  && nx <= m && map[ny][nx] != '#') {
                // 유효성 검증
                switch (map[ny][nx]) {

                    case '&' :
                    {
                        log = monsterArr[ny][nx].name;
                        // 보스가 아닌 몬스터
                        Monster curMonster = new Monster(monsterArr[ny][nx]);

                        // 첫 번째 공격 시 주인공의 공격력이 두 배로 적용
                        // ex. max(1, 공격력 * 2 - 몬스터의 방어력)
                        // 악세서리 DX와 시너지 -> 세 배로 적용

                        // 1. 전투 시작
                        int firstDamage = ATT + curWeapon;

                        // 악세서리 CO 적용
                        if (curAccessorySet.contains("CO")) {
                            if (curAccessorySet.contains("DX")) firstDamage *= 3;
                            else firstDamage *= 2;
                        }

                        curMonster.h -= Math.max(1, firstDamage - curMonster.a);

                        // 2. 전투 중

                        while (curMonster.h > 0) {
                            HP -= Math.max(1, curMonster.w - (DEF + curAmor));
                            if (HP <= 0) break;
                            curMonster.h -= Math.max(1, ATT + curWeapon - curMonster.a);
                        }

                        // 3. 전투 종료 -> 경험치 지급 및 레벨업 로직
                        if (HP > 0) {
                            if (curAccessorySet.contains("HR")) {
                                HP += 3;
                                HP = Math.min(MAXHP, HP);
                            }
                            if (curAccessorySet.contains("EX")) {
                                EXP += (int)((float)curMonster.e * 1.2);
                            } else {
                                EXP += curMonster.e;
                            }

                            if (EXP >= LV * 5) {
                                LV++;
                                MAXHP += 5;
                                HP = MAXHP;
                                EXP = 0;
                                ATT += 2;
                                DEF += 2;
                            }
                            map[ny][nx] = '.';
                        }
                    }
                    break;
                    case 'M' :
                    {

                        log = monsterArr[ny][nx].name;
                        Monster curMonster = new Monster(monsterArr[ny][nx]);
                        // 보스 몬스터
                        // 사냥 시 게임 종료

                        // 악세서리 CO 적용
                        // 첫 번째 공격 시 주인공의 공격력이 두 배로 적용
                        // ex. max(1, 공격력 * 2 - 몬스터의 방어력)
                        // 악세서리 DX와 시너지 -> 세 배로 적용

                        // 1. 전투 시작
                        int firstDamage = ATT + curWeapon;

                        // 악세서리 CO 적용
                        if (curAccessorySet.contains("CO")) {
                            if (curAccessorySet.contains("DX")) firstDamage *= 3;
                            else firstDamage *= 2;
                        }

                        curMonster.h -= Math.max(1, firstDamage - curMonster.a);

                        // 악세서리 HU 적용
                        // HU는 보스 몬스터와 전투에 돌입하는 순간 체력을 최대치까지 회복
                        // 보스의 첫 공격에 0의 데미지
                        if (curAccessorySet.contains("HU")) {
                            HP = MAXHP;
                            curMonster.h -= Math.max(1, ATT + curWeapon - curMonster.a);
                        }
//                        curMonster.h -= Math.max(1, ATT + curWeapon - curMonster.a);
                        // 2. 전투 중

                        while (curMonster.h > 0) {
                            HP -= Math.max(1, curMonster.w - (DEF + curAmor));
                            if (HP <= 0) break;
                            curMonster.h -= Math.max(1, ATT + curWeapon - curMonster.a);
                        }


                        // 3. 전투 종료 -> 경험치 지급 및 레벨업 로직
                        if (HP > 0) {

                            if (curAccessorySet.contains("HR")) {
                                HP += 3;
                                HP = Math.min(MAXHP, HP);
                            }
                            if (curAccessorySet.contains("EX")) {
                                EXP += (int)((float)curMonster.e * 1.2);
                            } else {
                                EXP += curMonster.e;
                            }

                            if (EXP >= LV * 5) {
                                LV++;
                                MAXHP += 5;
                                HP = MAXHP;
                                EXP = 0;
                                ATT += 2;
                                DEF += 2;
                            }

                            map[ny][nx] = '.';
                            isBossKilled = true;
                        }
                    }
                    break;
                    case 'B' :
                    {
                        map[ny][nx] = '.';
                        if (eventArr[ny][nx].isAccessory) {
                            // 악세서리의 경우
                            String type = eventArr[ny][nx].type;

                            if (curAccessorySet.size() < 4) {
                                // 장착할 수 있는 지 확인 -> 4칸이 다 차있는지
//                                if (!curAccessorySet.contains(type)) {
                                // 장착할 수 있는지 확인 -> 동일한 악세서리는 없는지

                                curAccessorySet.add(type);
                                // 장착
//                                }
                            }
                        } else {
                            if (eventArr[ny][nx].type.equals("W")) {
                                // 무기의 경우
                                curWeapon = eventArr[ny][nx].option;
                            } else {
                                // 방어구의 경우
                                curAmor = eventArr[ny][nx].option;
                            }
                        }

                    }
                    break;
                }
                curLoc[0] = ny;
                curLoc[1] = nx;
            }

            // Spike Trap 데미지 처리
            if (map[curLoc[0]][curLoc[1]] == '^') {
                log = "SPIKE TRAP";
                if (curAccessorySet.contains("DX")) HP -= 1;
                else HP -= 5;
            }

            TURN++;

            // 사망 처리
            if (HP <= 0) {
                if (curAccessorySet.contains("RE")) {
                    curAccessorySet.remove("RE");
                    HP = 15 + (LV * 5);
                    curLoc[0] = startLoc[0];
                    curLoc[1] = startLoc[1];
                } else {
                    HP = 0;
                    break;
                }
            }

            if (isBossKilled) break;

            // RE가 있다면 처음 위치로 이동
        }

        if (HP > 0) {
            map[curLoc[0]][curLoc[1]] = '@';
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        sb.append("Passed Turns : ").append(TURN).append('\n');
        sb.append("LV : ").append(LV).append('\n');
        sb.append("HP : ").append(HP).append('/').append(15 + LV * 5).append('\n');
        sb.append("ATT : ").append(ATT).append('+').append(curWeapon).append('\n');
        sb.append("DEF : ").append(DEF).append('+').append(curAmor).append('\n');
        sb.append("EXP : ").append(EXP).append('/').append(LV * 5).append('\n');

        if (HP > 0) {
            if (isBossKilled) sb.append("YOU WIN!");
            else sb.append("Press any key to continue.");
        } else {
            sb.append("YOU HAVE BEEN KILLED BY ").append(log).append("..");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}