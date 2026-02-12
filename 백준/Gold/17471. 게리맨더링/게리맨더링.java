import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int answer;
    static int[] cost;
    static boolean[] visited;
    static List<Integer>[] graph;
    static HashSet<Long> set = new HashSet<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new List[n + 1];
        cost = new int[n + 1];
        visited = new boolean[n + 1];
        answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= n ; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int near = Integer.parseInt(st.nextToken());

            for (int j = 0; j < near; j ++){
                int next = Integer.parseInt(st.nextToken());
                graph[i].add(next);
            }
        }
        calc(0);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.print(answer);
    }

    public static void calc(int idx){

        long key = makeKey();

        if (set.contains(key)) {
            return;
        }

        set.add(key);

        List<Integer> routeA = makeList(true);
        List<Integer> routeB = makeList(false);

        int score1 = bfs(routeA);
        int score2 = bfs(routeB);


        if (score1 != -1 && score2 != -1){
            answer = Math.min(Math.abs(score1 - score2),answer);
        }

        for (int i = idx; i <= n ; i ++){
            visited[i] = true;
            calc(i + 1);
            visited[i] = false;
        }
    }

    public static List<Integer> makeList(boolean flag){
        List<Integer> route = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (visited[i] == flag) {
                route.add(i);
            }
        }
        return route;
    }

    public static int bfs(List<Integer> list){
        if (list.isEmpty()) return -1;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(list.get(0));
        int sum = cost[list.get(0)];
        list.remove(0);

        while(!q.isEmpty()){
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (list.contains(next)) {
                    q.add(next);
                    sum += cost[next];
                    list.remove((Object)next);
                }
            }
        }

        if (!list.isEmpty()) return -1;
        return sum;
    }

    public static long makeKey(){
        long key = 0;
        for (int i = 1 ; i <= n ; i ++){
            if (visited[i]) {
                key += Math.pow(2, i);
            }
        }
        return key;
    }
}