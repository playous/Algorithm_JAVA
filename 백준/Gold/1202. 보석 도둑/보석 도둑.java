import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int weight;
        int value;
        Node(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        List<Integer> bag = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Node(m, v));
        }

        for (int i = 0; i < k; i++) {
            int c = Integer.parseInt(br.readLine());
            bag.add(c);
        }
        list.sort((a,b) ->a.weight - b.weight);
        bag.sort((a, b) -> a - b);

        int idx = 0;
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < k; i++) {
            int cur = bag.get(i);
            while (idx < n && list.get(idx).weight <= cur) {
                pq.add(list.get(idx).value);
                idx++;
            }
            if(!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

}

