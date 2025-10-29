import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] cost = new int[n + 1];
        int[] answer = new int[n + 1];
        int[] degree = new int[n + 1];
        List<Integer>[] list = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            cost[i] = c;
            while (true) {
                int prev = Integer.parseInt(st.nextToken());
                if (prev == -1) break;
                list[prev].add(i);
                degree[i]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                q.add(i);
                answer[i] = cost[i];
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : list[cur]) {
                answer[next] = Math.max(answer[next], cost[next] + answer[cur]);
                degree[next]--;
                if (degree[next] == 0) {
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(answer[i] + "\n");
        }
        bw.flush();
    }
}
