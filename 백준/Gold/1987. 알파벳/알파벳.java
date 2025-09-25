import java.util.*;
import java.io.*;

class Main
{
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] max;
    static char[][] map;
    static int R;
    static int C;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        max = new int[R][C];
        for (int i = 0; i < R ; i++){
            map[i] = br.readLine().toCharArray();
        }

        boolean[] flag = new boolean[26];
        boolean[][] visited = new boolean[R][C];
        flag[map[0][0] - 'A'] = true;
        
        dfs(0, 0, 1, visited, flag);

        int answer = 0;
        for (int i = 0; i < R ; i++){
            for (int j = 0; j < C ; j++){
                answer = Math.max(answer, max[i][j]);
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    public static void dfs(int r, int c, int count ,boolean[][] visited, boolean[] check) {
        max[r][c] = Math.max(max[r][c], count);
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if (nextR >= 0 && nextC >= 0 && nextR < R && nextC < C) {
                if (!check[map[nextR][nextC] - 'A'] && !visited[nextR][nextC]) {
                    check[map[nextR][nextC] - 'A'] = true;
                    visited[nextR][nextC] = true;
                    dfs(nextR, nextC, count + 1,visited, check);
                    check[map[nextR][nextC] - 'A'] = false;
                    visited[nextR][nextC] = false;
                }
            }
        }

    }
}