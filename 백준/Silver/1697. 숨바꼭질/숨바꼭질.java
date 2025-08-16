import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int data;
        int level;

        public Node(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            bw.write(String.valueOf(n - k));
            bw.flush();
            return;
        }

        boolean[] visited = new boolean[100001];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(n, 0));
        visited[n] = true;

        int answer = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.data == k) {
                answer = cur.level;
                break;
            }

            int[] nextPositions = {cur.data + 1, cur.data - 1, cur.data * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    q.add(new Node(next, cur.level + 1));
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}