import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 32;

        char[][] map = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = s.charAt(j - 1);
            }
        }

        for (int i = 1; i <= n - 7; i++) {
            for (int j = 1; j <= m - 7; j++) {
                answer = Math.min(check(i, j, map), answer);
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static int check(int i, int j, char[][] map) {
        char s = map[i][j];
        int count1 = 0;
        int count2 = 0;
        for (int k = i; k <= i + 7; k++) {
            for (int q = j ; q <= j + 7 ; q++) {
                if((k + q) % 2 == 0){
                    if (map[k][q] != s) count1++;
                }
                else {
                    if (map[k][q] == s) count1++;
                }
            }
        }
        for (int k = i; k <= i + 7; k++) {
            for (int q = j ; q <= j + 7 ; q++) {
                if((k + q) % 2 == 0){
                    if (map[k][q] == s) count2++;
                }
                else {
                    if (map[k][q] != s) count2++;
                }
            }
        }
        return Math.min(count1, count2);
    }

}