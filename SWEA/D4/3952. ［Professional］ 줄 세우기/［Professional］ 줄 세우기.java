import java.io.*;
import java.util.*;

public class Solution {
    static int n, m;
    static List<Integer>[] list;
    static int[] degree;
    static List<Integer> answerList;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            list = new List[n + 1];
            degree = new int[n + 1];
            answerList = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                degree[b]++;
            }

            bfs();

            sb.append("#").append(t).append(" ");

            for (int num : answerList){
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static void bfs(){

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1 ; i <= n ; i++){
            if(degree[i] == 0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int cur = pq.poll();
            answerList.add(cur);
            for (int next : list[cur]){
                degree[next]--;
                if (degree[next] == 0){
                    pq.add(next);
                }
            }
        }

    }
}