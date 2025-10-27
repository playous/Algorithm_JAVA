import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int num;
        int level;
        public Node(int num, int level) {
            this.num = num;
            this.level = level;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n  = Integer.parseInt(br.readLine());

        List<Integer>[] list = new List[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == 'Y')
                    list[i].add(j);
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            Queue<Node> q = new ArrayDeque<>();
            visited[i] = true;
            int count = 0;
            for (int num : list[i]){
                q.add(new Node(num , 1));
                visited[num] = true;
            }
            while (!q.isEmpty()){
                Node cur = q.poll();
                int friend = cur.num;
                int level = cur.level;
                if (level == 3) continue;
                count++;
                for (int num : list[friend]){
                    if (!visited[num]){
                        q.add(new Node(num , level + 1));
                        visited[num] = true;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}