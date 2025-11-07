import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int name;
        int level;
        Node(int name, int level){
            this.name = name;
            this.level = level;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n + 1];

        List<Integer>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            answer[i] = -1;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                if (next == 0) break;
                list[i].add(next);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.level - b.level);
        boolean[] visited = new boolean[n + 1];

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, 0));
            answer[a] = 0;
            visited[a] = true;
        }


        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curName = cur.name;
            int curLevel = cur.level;
            if (!visited[curName]) {
                answer[curName] = curLevel;
                visited[curName] = true;
            }
            for (int next : list[curName]){
                if(!visited[next]) {
                    int count = 0;
                    for (int nnext : list[next]) {
                        if (visited[nnext]) count++;
                    }
                    if (count * 2 >= list[next].size()) {
                        pq.add(new Node(next, curLevel + 1));
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(String.valueOf(answer[i]) + " ");
        }
        bw.flush();


    }

}

