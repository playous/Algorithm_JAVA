import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int next;
        long time;
        public Node(int next, long time){
            this.next = next;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Node>[] edge = new List[n];

        for (int i = 0; i < n; i++) {
            edge[i] = new ArrayList<>();
        }

        boolean[] canGo = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            canGo[i] = a == 0;
        }
        canGo[n - 1] = true;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if (canGo[a] && canGo[b]) {
                edge[a].add(new Node(b, t));
                edge[b].add(new Node(a, t));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));

        long[] minTime = new long[n];
        Arrays.fill(minTime,Long.MAX_VALUE);

        for (Node node : edge[0]){
            pq.add(node);
            minTime[node.next] = node.time;
        }

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curNext = cur.next;
            long curTime = cur.time;

            if (curTime > minTime[curNext]) continue;

            if (curNext == n-1){
                break;
            }

            for (Node node : edge[curNext]){
                if (minTime[node.next] > curTime + node.time){
                    pq.add(new Node(node.next, curTime + node.time));
                    minTime[node.next] = curTime + node.time;
                }

            }
        }

        bw.write(String.valueOf(minTime[n - 1] == Long.MAX_VALUE ? -1 : minTime[n - 1]));
        bw.flush();
    }
}
