import java.io.*;
import java.util.*;

class Main {
    static int answer = 0;
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][9];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] flag = new boolean[9];
        int[] state = new int[9];
        state[3] = 0;
        flag[0] = true;

        setState(flag, state, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void setState(boolean[] flag, int[] state, int seq) {
        if (seq == 3) seq = 4;
        if (seq == 9) {
            answer = Math.max(answer, calcScore(state));
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!flag[i]) {
                state[seq] = i;
                flag[i] = true;
                setState(flag,state,seq+1);
                flag[i] = false;
            }
        }
    }

    static int calcScore(int[] state) {
        int cur = 0;
        int score = 0;

        for (int i = 0; i < n; i++) {
            int outCount = 0;
            boolean[] base = new boolean[4];

            while (outCount < 3) {
                int hit = arr[i][state[cur]];

                if (hit == 0) {
                    outCount++;
                } else {
                    for (int j = 3; j >= 1; j--) {
                        if (base[j]) {
                            if (j + hit >= 4) {
                                score++;
                            } else {
                                base[j + hit] = true;
                            }
                            base[j] = false;
                        }
                    }

                    if (hit == 4) {
                        score++;
                    } else {
                        base[hit] = true;
                    }
                }

                cur = (cur + 1) % 9;
            }
        }

        return score;
    }
}

