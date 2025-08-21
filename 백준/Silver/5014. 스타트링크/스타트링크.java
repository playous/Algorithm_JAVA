import java.io.*;
import java.util.*;

public class Main {
    static class Floor{
        int floor;
        int level;
        public Floor(int floor, int level) {
            this.floor = floor;
            this.level = level;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[f + 1];
        Queue<Floor> q = new ArrayDeque<>();
        q.add(new Floor(s, 0));
        visited[s] = true;
        int answer = -1;
        if (s != g){
            while(!q.isEmpty()) {
                Floor cur = q.poll();
                int level = cur.level;
                int floor = cur.floor;
                if (floor == g){
                    answer = level;
                }
                if(floor + u <= f) {
                    if (!visited[floor + u]) {
                        q.add(new Floor(floor + u, level + 1));
                        visited[floor + u] = true;
                    }
                }
                if(floor - d >= 1) {
                    if (!visited[floor - d]) {
                        q.add(new Floor(floor - d, level + 1));
                        visited[floor - d] = true;
                    }
                }
            }
        }
        if (s == g) answer = 0;

        bw.write(String.valueOf(answer == -1 ? "use the stairs" : answer));
        bw.flush();
    }
}