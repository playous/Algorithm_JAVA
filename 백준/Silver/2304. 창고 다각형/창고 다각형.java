import java.io.*;
import java.util.*;

public class Main {
    static class Rod {
        int x;
        int y;

        public Rod(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Rod> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Rod(x, y));
        }

        list.sort((a, b) -> a.x - b.x);

        int maxH = 0;
        int maxIdx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).y > maxH) {
                maxH = list.get(i).y;
                maxIdx = i;
            }
        }

        int answer = 0;

        int prevX = list.get(0).x;
        int prevY = list.get(0).y;

        for (int i = 0; i <= maxIdx; i++) {
            Rod r = list.get(i);
            if (r.y > prevY || i == maxIdx) {
                answer += (r.x - prevX) * prevY;
                prevX = r.x;
                prevY = r.y;
            }
        }

        prevX = list.get(n-1).x + 1;
        prevY = list.get(n-1).y;

        for (int i = n - 1; i >= maxIdx; i--) {
            Rod r = list.get(i);
            if (r.y > prevY || i == maxIdx) {
                answer += (prevX - (r.x + 1)) * prevY;
                prevX = r.x + 1;
                prevY = r.y;
            }
        }

        answer += maxH;
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}