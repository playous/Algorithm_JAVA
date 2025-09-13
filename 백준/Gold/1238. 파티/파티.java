import java.io.*;
import java.util.*;

public class Main {
    static class City{
        int name;
        int cost;
        public City(int name, int cost) {
            this.name = name;
            this.cost = cost;
        }
    }

    static int n,m,x;
    static List<City>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        list = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list[s].add(new City(e, t));
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            int go = dijkstra(i, x);
            int back = dijkstra(x, i);
            max = Math.max(max, go + back);
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    static int dijkstra(int start, int end) {
        int[] minCost = new int[n + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        PriorityQueue<City> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.add(new City(start, 0));
        while (!pq.isEmpty()) {
            City c = pq.poll();
            int cost = c.cost;
            int cur = c.name;
            if (cost > minCost[cur]) {
                continue;
            }
            for (City city : list[cur]) {
                if (city.cost + cost < minCost[city.name]) {
                    pq.add(new City(city.name, cost + city.cost));
                    minCost[city.name] = city.cost + cost;
                }
            }
        }
        return minCost[end];
    }
}

