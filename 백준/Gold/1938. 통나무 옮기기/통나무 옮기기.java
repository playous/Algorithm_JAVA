import java.io.*;
import java.util.*;

public class Main {
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    static boolean flagB, flagG; // true -> 세로 , false -> 가로
    static char[][] map;
    static HashMap<String, Integer> memo;
    static int goalC, goalR, n;

    static class State {
        int r, c, count;
        boolean flag;

        State(int r, int c, boolean flag, int count) {
            this.r = r;
            this.c = c;
            this.flag = flag;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new char[n + 1][n + 1];
        memo = new HashMap<>();

        int bCount = 0;
        int eCount = 0;

        int r = 0;
        int c = 0;
        int prevB = 0;
        int prevE = 0;

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= n; j++) {
                map[i][j] = line.charAt(j - 1);
                if (map[i][j] == 'B') {
                    bCount++;
                    if (bCount == 1){
                        prevB = j;
                    }
                    if (bCount == 2){
                        c = j;
                        r = i;
                    }
                }
                if (map[i][j] == 'E') {
                    eCount++;
                    if (eCount == 1){
                        prevE = j;
                    }
                    if (eCount == 2){
                        goalC = j;
                        goalR = i;
                    }
                }
            }
        }

        if (c == prevB) flagB = true; // 세로
        else flagB = false; // 가로
        if (goalC == prevE) flagG = true;
        else flagG = false;

        int answer = bfs(r, c, flagB);

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static int bfs(int startR, int startC, boolean startFlag) {
        Queue<State> queue = new ArrayDeque<>();
        queue.offer(new State(startR, startC, startFlag, 0));

        String startKey = startR + "," + startC + "," + startFlag;
        memo.put(startKey, 0);

        while (!queue.isEmpty()) {
            State current = queue.poll();
            int r = current.r;
            int c = current.c;
            boolean flag = current.flag;
            int count = current.count;

            if (c == goalC && r == goalR && flag == flagG) {
                return count;
            }

            if (!flag) {
                for (int i = 0; i < 4; i++) {
                    int curC = dc[i] + c;
                    int curR = dr[i] + r;
                    if (curC >= 2 && curC <= n - 1 && curR >= 1 && curR <= n) {
                        if (map[curR][curC] != '1' && map[curR][curC - 1] != '1' && map[curR][curC + 1] != '1') {
                            String key = curR + "," + curC + "," + flag;
                            if (!memo.containsKey(key) || memo.get(key) > count + 1) {
                                memo.put(key, count + 1);
                                queue.offer(new State(curR, curC, flag, count + 1));
                            }
                        }
                    }
                }

                if (c >= 2 && c <= n - 1 && r >= 2 && r <= n - 1) {
                    boolean canRotate = true;
                    for (int k = c - 1; k <= c + 1; k++) {
                        if (map[r-1][k] == '1' || map[r+1][k] == '1') {
                            canRotate = false;
                            break;
                        }
                    }
                    if (canRotate) {
                        String key = r + "," + c + "," + (!flag);
                        if (!memo.containsKey(key) || memo.get(key) > count + 1) {
                            memo.put(key, count + 1);
                            queue.offer(new State(r, c, !flag, count + 1));
                        }
                    }
                }
            }

            if (flag) {
                for (int i = 0; i < 4; i++) {
                    int curC = dc[i] + c;
                    int curR = dr[i] + r;
                    if (curC >= 1 && curC <= n && curR >= 2 && curR <= n - 1) {
                        if (map[curR][curC] != '1' && map[curR - 1][curC] != '1' && map[curR + 1][curC] != '1') {
                            String key = curR + "," + curC + "," + flag;
                            if (!memo.containsKey(key) || memo.get(key) > count + 1) {
                                memo.put(key, count + 1);
                                queue.offer(new State(curR, curC, flag, count + 1));
                            }
                        }
                    }
                }
                if (c >= 2 && c <= n - 1 && r >= 2 && r <= n - 1) {
                    boolean canRotate = true;
                    for (int k = r - 1; k <= r + 1; k++) {
                        if (map[k][c-1] == '1' || map[k][c+1] == '1') {
                            canRotate = false;
                            break;
                        }
                    }
                    if (canRotate) {
                        String key = r + "," + c + "," + (!flag);
                        if (!memo.containsKey(key) || memo.get(key) > count + 1) {
                            memo.put(key, count + 1);
                            queue.offer(new State(r, c, !flag, count + 1));
                        }
                    }
                }
            }
        }

        return 0;
    }
}