import java.io.*;
import java.util.*;

public class Solution {

    static int v,e;
    static List<Integer>[] graph;
    static int[] degree;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        for (int t = 1; t <= 10 ; t++){
            st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph = new List[v + 1];
            degree = new int[v + 1];

            for (int i = 1; i <= v; i++){
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= e ; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                degree[b]++;
            }

            Queue<Integer> q = new ArrayDeque<>();

            for (int i = 1; i <= v ; i ++){
                if (degree[i] == 0) q.add(i);
            }

            sb.append("#").append(t);
            while(!q.isEmpty()){
                int cur = q.poll();
                sb.append(" ").append(cur);

                for (int next : graph[cur]){
                    degree[next]--;
                    if (degree[next] == 0){
                        q.add(next);
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}