import java.io.*;
import java.util.*;

public class Main {
    static class City {
        int name;
        int cost;
        public City(int name, int cost){
            this.name = name;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<City>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new City(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] cost = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i != start){
                cost[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<City> q = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        q.add(new City(start, 0));
        cost[start] = 0;
        while (!q.isEmpty()){
            City cur = q.poll();
            if (cur.cost > cost[cur.name]) continue;
            for (City c : list[cur.name]) {
                if (cost[c.name] > cost[cur.name] + c.cost){
                    cost[c.name] = cost[cur.name] + c.cost;
                    q.add(new City(c.name, cost[c.name]));
                }
            }
        }

        bw.write(String.valueOf(cost[end]));
        bw.flush();
    }
}