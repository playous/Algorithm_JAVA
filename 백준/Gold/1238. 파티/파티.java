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

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Node>[] list = new List[n + 1];
        List<Node>[] reverseList = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            reverseList[b].add(new Node(a, c));
        }

        int[] dist = new int[n + 1];
        int[] reverseDist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dist[i] = 100000000;
            reverseDist[i] = 100000000;
        }

        dist[x] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(x, 0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            int name = cur.name;
            int cost = cur.cost;

            if(cost > dist[name]) continue;

            for (Node next : list[name]){
                if (cost + next.cost < dist[next.name]){
                    dist[next.name] = cost + next.cost;
                    pq.add(new Node(next.name, dist[next.name]));
                }
            }
        }

        pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(x, 0));
        reverseDist[x] = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            int name = cur.name;
            int cost = cur.cost;

            if(cost > reverseDist[name]) continue;

            for (Node next : reverseList[name]){
                if (cost + next.cost < reverseDist[next.name]){
                    reverseDist[next.name] = cost + next.cost;
                    pq.add(new Node(next.name, reverseDist[next.name]));
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n ; i ++){
            answer = Math.max(dist[i] + reverseDist[i], answer);
        }

        System.out.println(answer);
    }
}
