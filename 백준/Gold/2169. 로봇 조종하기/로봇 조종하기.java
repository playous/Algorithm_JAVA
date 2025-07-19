import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 왼쪽 -> 오른쪽
        int[][] dp1 = new int[n+2][m+2];

        // 오른쪽 -> 왼쪽
        int[][] dp2 = new int[n+2][m+2];

        for (int i = 1; i <= m; i++) {
            dp1[1][i] = dp1[1][i-1] + map[1][i];
            dp2[1][i] = dp2[1][i-1] + map[1][i];
        }

        for (int i = 2; i <= n; i++) {
            dp1[i][1] = dp1[i-1][1] + map[i][1];
            dp1[i][0] = -Integer.MAX_VALUE;

            dp2[i][m] = dp2[i-1][m] + map[i][m];
            dp2[i][m+1] = -Integer.MAX_VALUE;

            for (int j = 1; j <= m; j++) {
                dp1[i][j] = Math.max(Math.max(dp1[i-1][j], dp2[i-1][j]), dp1[i][j-1]) + map[i][j];
                dp2[i][m-j+1] = Math.max(Math.max(dp1[i-1][m-j+1], dp2[i-1][m-j+1]), dp2[i][m-j+2]) + map[i][m-j+1];
            }
        }

        int answer = dp1[n][m];
        
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}