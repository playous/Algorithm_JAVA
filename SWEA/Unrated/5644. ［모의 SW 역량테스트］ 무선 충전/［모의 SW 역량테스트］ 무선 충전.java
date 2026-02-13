import java.util.*;
import java.io.*;

class Solution {
    static int[][][] map;
    static int M, A;
    static int[] routeA, routeB;
    static int ar, ac, br, bc;

    static int[] dr = {0, -1, 0, 1, 0};
    static int[] dc = {0, 0, 1, 0, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br2.readLine().trim());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br2.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            map = new int[A + 1][11][11];
            routeA = new int[M + 1];
            routeB = new int[M + 1];

            st = new StringTokenizer(br2.readLine());
            for (int i = 1; i <= M; i++) {
                routeA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br2.readLine());
            for (int i = 1; i <= M; i++) {
                routeB[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= A; i++) {
                st = new StringTokenizer(br2.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int flag = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                addBc(i, y, x, flag, cost);
            }

            ar = 1; ac = 1;
            br = 10; bc = 10;
            int answer = 0;

            for (int i = 0; i <= M; i++) {
                ar += dr[routeA[i]];
                ac += dc[routeA[i]];
                br += dr[routeB[i]];
                bc += dc[routeB[i]];
                answer += calc();
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static int calc() {
        int best = 0;

        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= A; j++) {
                int a = (i == 0) ? 0 : map[i][ar][ac];
                int b = (j == 0) ? 0 : map[j][br][bc];

                if (i != 0 && i == j) {
                    int p = Math.max(a, b);
                    a = p / 2;
                    b = p / 2;
                }

                best = Math.max(best, a + b);
            }
        }
        return best;
    }

    public static void addBc(int name, int r, int c, int flag, int cost) {
        for (int i = r - flag; i <= r + flag; i++) {
            for (int j = c - flag; j <= c + flag; j++) {
                if (i < 1 || i > 10 || j < 1 || j > 10) continue;
                if (distance(r, c, i, j) <= flag) {
                    map[name][i][j] = cost;
                }
            }
        }
    }

    public static int distance(int r, int c, int r1, int c1) {
        return Math.abs(r - r1) + Math.abs(c - c1);
    }
}