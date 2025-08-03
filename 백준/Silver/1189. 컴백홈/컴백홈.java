import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n,m,k;
    static int answer = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == 'T') {
                    visited[i][j] = true;
                }
            }
        }


        visited[n-1][0] = true;
        backTrack(visited,n-1,0,1);


        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void backTrack(boolean[][] visited, int row, int col , int count) {
        if (count == k && row == 0 && col == m -1) {
            answer++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int cRow = row + dx[i];
            int cCol = col + dy[i];
            if (cRow >= 0 && cCol >= 0 && cRow < n && cCol < m && !visited[cRow][cCol]) {
                visited[row][col] = true;
                backTrack(visited, cRow, cCol, count + 1);
                visited[row][col] = false;
            }
        }
    }
}