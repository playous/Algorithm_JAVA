import java.util.*;
import java.io.*;

public class Solution {

	static int[] parents;
	static int v,e;
	static long answer;
	
	static class Node {
		int a;
		int b;
		int c;
		Node(int a, int b, int c){
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
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			parents = new int[v + 1];
			
			for (int i = 1; i <= v; i ++) {
				parents[i] = i;
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.c - b.c);
			
			for (int i = 0; i < e ; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				pq.add(new Node(a, b, c));
			}
			
			answer = 0;
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				union(cur.a, cur.b, cur.c);
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			
		}
		System.out.print(sb.toString());
		

	}
	
	public static void union(int a, int b, int c) {
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
}
