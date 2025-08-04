import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] map = new int[11][5];
        for (int i = 1 ; i <= 10 ; i ++){
            int num = i;
            for (int j = 1; j <= 4; j++) {
                map[i][j] = num % 10 == 0 ? 10 : num % 10;
                num *= i;
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < t ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            bw.write(map[n % 10 == 0 ? 10 : n % 10][m % 4 == 0 ? 4 : m % 4] + "\n");
        }
        bw.flush();
    }
}
