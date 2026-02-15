import java.io.*;
import java.util.*;

public class Solution {
    static int n, m;
    static List<Integer>[] list;
    static HashSet<Integer>[] set;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());

            list = new List[n + 1];
            set = new HashSet[n + 1];

            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
                set[i] = new HashSet<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
            }
            for (int i = 1; i <= n; i++) {
                visited = new boolean[n + 1];
                dfs(i, i);
            }

            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if (set[i].size() == n - 1){
                    answer++;
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void dfs(int idx, int start){
        visited[idx] = true;
        for (int next : list[idx]) {
            if (!visited[next]) {
                visited[next] = true;
                set[next].add(start);
                set[start].add(next);
                dfs(next, start);
            }
        }
    }

}