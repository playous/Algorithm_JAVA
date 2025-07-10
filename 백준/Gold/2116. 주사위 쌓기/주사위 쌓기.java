import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] dice = new int[n][6];
        int[][] max = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
                if (j != 0 && j != 5 ){
                    max[i][0] = Math.max(max[i][0], dice[i][j]);
                }
                if (j != 1 && j != 3){
                    max[i][1] = Math.max(max[i][1], dice[i][j]);
                }
                if (j != 2 && j != 4) {
                    max[i][2] = Math.max(max[i][2], dice[i][j]);
                }
            }
        }

        int answer = 0;
        int[] diceIdx = {5, 3, 4, 1, 2, 0};
        for (int i = 0; i < 6; i++) {
            int idx = diceIdx[i];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int k;
                int up = dice[j][idx];
                if (idx == 0 || idx == 5){
                    sum += max[j][0];
                }
                else if (idx == 1 || idx == 3){
                    sum += max[j][1];
                }
                else if (idx == 2 || idx == 4){
                    sum += max[j][2];
                }
                if (j < n - 1) {
                    for (k = 0; k < 6; k++) {
                        if (dice[j+1][k] == up) break;
                    }
                    idx = diceIdx[k];
                }
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}



