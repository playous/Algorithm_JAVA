import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int answer= 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            for (int i = 0 ; i < n ; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                if (check(x1, y1, x2, y2, x, y, r)) answer++;
            }
            bw.write(answer + "\n");
            t--;
        }
        bw.flush();
    }

    static boolean check(int x1, int y1, int x2, int y2, int x, int y, int r) {
        int count = 0;
        if ((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y)  < r * r) {
            count++;
        }
        if ((x2 - x) * (x2 - x) + (y2 - y) * (y2 - y)  < r * r) {
            count++;
        }
        return count == 1;
    }
}