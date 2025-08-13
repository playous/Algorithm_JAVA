import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());

        int answer = calDist(sx, sy, x, y);
        int answerX = sx;
        int answerY = sy;
        for (int i = - 200; i <= 200; i++) {
            for (int j = - 200; j <= 200; j++) {
                if (check(sx, dx, i)) continue;
                if (check(sy, dy, j)) continue;
                if((j - sy) * dx == (i - sx) * dy){
                    int cur = calDist(i, j, x, y);
                    if (answer > cur ){
                        answerX = i;
                        answerY = j;
                        answer = cur;
                    }
                }
            }
        }

        bw.write(answerX + " " + answerY);
        bw.flush();
    }

    static boolean check(int start, int dxy, int ij) {
        if (dxy > 0 && ij < start) {
            return true;
        }
        if (dxy < 0 && ij > start) {
            return true;
        }
        if (dxy == 0 && ij != start) {
            return true;
        }
        return false;
    }

    static int calDist(int x1, int y1, int x2, int y2) {
        int a = Math.abs(x1 - x2);
        int b = Math.abs(y1 - y2);
        return(a * a + b * b);
    }

}