import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static int[][][] dp;

    static int[] dr = {1, 1, 1};
    static int[] dc = {-1, 0, 1};

    static int n,m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = 1000000;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < 3; k++) {
                dp[0][j][k] = map[0][j];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++)     {
                for (int cur = 0; cur < 3; cur++) {
                    for (int next = 0; next < 3; next++) {
                        if (cur == next) continue;
                        int nr = i + dr[next];
                        int nc = j + dc[next];

                        if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                            dp[nr][nc][next] = Math.min(
                                    dp[nr][nc][next],
                                    dp[i][j][cur] + map[nr][nc]
                            );
                        }
                    }
                }
            }
        }


            int answer = 1000000;
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    answer = Math.min(answer, dp[n - 1][j][k]);
                }
            }

            bw.write(String.valueOf(answer));
            bw.flush();
        }

    }