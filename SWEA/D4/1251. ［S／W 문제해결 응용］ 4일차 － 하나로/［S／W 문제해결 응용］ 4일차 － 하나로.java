import java.util.*;
import java.io.*;

public class Solution {

	static int[] parents;
	static int n;
	static double answer;
	
	static double e;
	
	static long[][] dis;
	static Node[] nodes;
	
	static class Node{
        int x;
        int y;
    }
	
	static class Node2 {
		int a;
		int b;
		long c;
		Node2(int a, int b, long c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T ; t++) {
			n = Integer.parseInt(br.readLine());
			nodes = new Node[n + 1];
			parents = new int[n + 1];
			dis = new long[n + 1][n + 1];
			
			for (int i = 1; i <= n; i ++) {
				parents[i] = i;
				nodes[i] = new Node();
			}
			
			st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n ; i ++){
                nodes[i].x = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n ; i ++){
                nodes[i].y = Integer.parseInt(st.nextToken());
            }
            
            double e = Double.parseDouble(br.readLine());
            
            calDis(1);
			
			PriorityQueue<Node2> pq = new PriorityQueue<>((a, b) -> Long.compare(a.c, b.c));
			
			for (int i = 1; i <= n ; i++) {
				for (int j = i + 1; j <= n ; j++) {
					pq.add(new Node2(i, j, dis[i][j]));
				}
			}
			
			answer = 0;
			
			while(!pq.isEmpty()) {
				Node2 cur = pq.poll();
				
				union(cur.a, cur.b, cur.c * e);
			}
			
			sb.append("#").append(t).append(" ").append(Math.round(answer)).append("\n");
			
		}
		System.out.print(sb.toString());
		

	}
	
	public static void union(int a, int b, double c) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA == rootB) return;
		
		parents[rootA] = rootB;
		answer += c;
	}
	
	public static int findSet(int a) {
		if (a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static void calDis(int idx){
        if (idx == n) return;
 
        int curX = nodes[idx].x;
        int curY = nodes[idx].y;
 
        for (int i = idx + 1; i <= n ; i ++){
            int nextX = nodes[i].x;
            int nextY = nodes[i].y;
            double dis1 = Math.pow((curX - nextX), 2) + Math.pow((curY - nextY), 2);
 
            dis[idx][i] = (long)dis1;
            dis[i][idx] = (long)dis1;
        }
 
        calDis(idx + 1);
    }
}