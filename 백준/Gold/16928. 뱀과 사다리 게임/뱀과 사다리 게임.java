import java.io.*;
import java.util.*;

public class Main {
    static class Loc{
        int x;
        int level;
        public Loc(int x,int level){
            this.x = x;
            this.level = level;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] up = new int[101];
        int[] down = new int[101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            up[x] = y;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            down[x] = y;
        }

        int[] visited = new int[101];
        Arrays.fill(visited,1000);

        Queue<Loc> q = new ArrayDeque<>();
        q.add(new Loc(1, 0));

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            int cur = loc.x;
            int level = loc.level;
            int nextLevel = level + 1;

            for (int i = cur + 1; i <= cur + 6 && i <= 100; i++) {
                if (up[i] != 0) {
                    if (visited[up[i]] > nextLevel) {
                        visited[up[i]] = nextLevel;
                        q.add(new Loc(up[i], nextLevel));
                    }
                }
                else if (down[i] != 0) {
                    if (visited[down[i]] > nextLevel) {
                        visited[down[i]] = nextLevel;
                        q.add(new Loc(down[i], nextLevel));
                    }
                }
                else if (nextLevel < visited[i]) {
                    visited[i] = nextLevel;
                    q.add(new Loc(i, nextLevel));
                }
            }

        }

        bw.write(String.valueOf(visited[100]));
        bw.flush();
    }
}

