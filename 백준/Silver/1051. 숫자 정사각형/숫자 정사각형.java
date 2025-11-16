import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, calc(i,j));
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static int calc(int r, int c){
        int goal = map[r][c];
        int size = 0;
        int count = 0;
        while(r + count < n && c + count < m){
            if (map[r][c + count] == goal) {
                if (map[r + count][c] == goal){
                    if (map[r + count][c + count] == goal){
                        size = count + 1;
                    }
                }
            }
            count++;
        }
        return size * size;
    }
}