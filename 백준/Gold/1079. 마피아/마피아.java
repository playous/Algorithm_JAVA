import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int answer = 0;
    static int[][] map;
    static int[] R;
    static boolean[] killed;
    static int n, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        R = new int[n];
        killed = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            R[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        num = Integer.parseInt(br.readLine());

        if (n % 2 == 0){
            backTrack(killed, R, 0, true);
        }
        else {
            backTrack(killed, R, 0, false);

        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void backTrack(boolean[] killed, int[] R, int nightCount, boolean isNight){
        if (isNight) {
            for (int i = 0; i < n; i++) {
                if (killed[i]) continue;
                if (i == num) {
                    answer = Math.max(answer, nightCount);
                    continue;
                }
                killed[i] = true;
                for (int j = 0; j < n; j++) {
                    R[j] += map[i][j];
                }
                backTrack(killed, R, nightCount + 1, !isNight);
                killed[i] = false;
                for (int j = 0; j < n; j++) {
                    R[j] -= map[i][j];
                }
            }

        }
        else {
            int curKilled = isMax(R, killed);
            if (curKilled == num){
                answer = Math.max(answer, nightCount);
            }
            else {
                killed[curKilled] = true;
                backTrack(killed, R, nightCount, !isNight);
                killed[curKilled] = false;
            }
        }
    }

    static int isMax(int[] R, boolean[] killed){
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (killed[i]) continue;
            if (R[i] > max) {
                max = R[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}

