import java.io.*;
import java.util.*;

public class Solution {

    static int n;
    static long[][] dis;
    static boolean[] visited;
    static Node[] nodes;

    static class Node{
        int x;
        int y;
    }

    static class Node2{
        int next;
        long value;
        Node2(int next, long value){
            this.next = next;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1 ; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            dis = new long[n + 1][n + 1];
            visited = new boolean[n + 1];
            nodes = new Node[n + 1];
            double answer = 0;

            for (int i = 1; i <= n ; i ++){
                nodes[i] = new Node();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n ; i ++){
                nodes[i].x = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n ; i ++){
                nodes[i].y = Integer.parseInt(st.nextToken());
            }

            double e = Double.parseDouble(br.readLine());

            calDis(1);

            PriorityQueue<Node2> pq = new PriorityQueue<>((a, b) -> Long.compare(a.value, b.value));

            for (int i = 2; i <= n; i++) {
                pq.add(new Node2(i, dis[1][i]));
            }
            visited[1] = true;

            while(!pq.isEmpty()) {
                Node2 cur = pq.poll();
                int next = cur.next;
                double value = cur.value;
                if (visited[next]) continue;
                visited[next] = true;
                answer += (value * e);

                for (int i = 2; i <= n; i++) {
                    if (!visited[i]) pq.add(new Node2(i, dis[next][i]));
                }
            }

            sb.append("#").append(t).append(" ").append(Math.round(answer)).append("\n");
        }


        System.out.println(sb.toString());
    }

    static void calDis(int idx){
        if (idx == n) return;

        int curX = nodes[idx].x;
        int curY = nodes[idx].y;

        for (int i = idx + 1; i <= n ; i ++){
            int nextX = nodes[i].x;
            int nextY = nodes[i].y;
            double dis1 = Math.pow((curX - nextX), 2) + Math.pow((curY - nextY), 2);

            dis[idx][i] = (long)dis1;
            dis[i][idx] = (long)dis1;
        }

        calDis(idx + 1);
    }
}