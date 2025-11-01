import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int end;
        int cost;
        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Node(end, cost));
        }

        list.sort((a, b) -> b.end - a.end);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int answer = 0;

        int idx = 0;
        for (int day = n ; day > 0 ; day--) {
            while(idx < n && list.get(idx).end >= day){
                pq.add(list.get(idx).cost);
                idx++;
            }

            if (!pq.isEmpty()){
                answer += pq.poll();
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}

