import java.io.*;

public class Main {
    static int answer = 0;
    static int n;

    static boolean[] col;
    static boolean[] check1;
    static boolean[] check2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        col = new boolean[n + 1];
        check1 = new boolean[2 * n + 1]; // 대각선 "/"
        check2 = new boolean[2 * n + 1]; // 대각선 "\"

        backTrack(1);

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void backTrack(int currentRow) {
        if(currentRow > n){
            answer++;
            return;
        }

        for (int j = 1; j <= n; j++) {
            if (canQueen(currentRow, j)) {
                col[j] = true;
                check1[currentRow - j + n] = true;
                check2[currentRow + j] = true;

                backTrack(currentRow + 1);

                col[j] = false;
                check1[currentRow - j + n] = false;
                check2[currentRow + j] = false;
            }
        }
    }

    static boolean canQueen(int x, int y) {
        return !col[y] && !check1[x - y + n] && !check2[x + y];
    }
}