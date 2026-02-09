import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int name;
        int cost;
        Node(int name, int cost){
            this.name = name;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Node>[] list = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            int name = cur.name;
            int cost = cur.cost;
            visited[name] = true;

            if(cost > dist[name]) continue;
            
            for (Node next : list[name]){
                if(visited[next.name]) continue;
                if (cost + next.cost < dist[next.name]){
                    dist[next.name] = cost + next.cost;
                    pq.add(new Node(next.name, dist[next.name]));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
