import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer>[] list = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> q = new ArrayDeque<>();

        q.add(1);
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        int answer = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            for (int next : list[cur]){
                if (!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }
}
