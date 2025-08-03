import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            int[] cost = new int[n + 1];
            List<Integer>[] graph = new ArrayList[n + 1];
            int[] level = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i <= k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                level[b]++;
            }
            int w = Integer.parseInt(br.readLine());
            int answer = cal(graph, cost, level, w, n);
            bw.write(answer + "\n");
            t--;
        }
        bw.flush();
    }

    static int cal (List<Integer>[] graph, int[] cost, int[] level, int w, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (level[i] == 0) {
                queue.offer(i);
                dp[i] = cost[i];
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == w) {
                return dp[current];
            }

            for (int next : graph[current]) {
                int time = dp[current] + cost[next];
                dp[next] = Math.max(dp[next], time);
                level[next]--;
                if (level[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return dp[w];
    }
}
