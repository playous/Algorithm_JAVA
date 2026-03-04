import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	
	static class Node{
		int p;
		int level;
		Node(int p , int level){
			this.p = p;
			this.level = level;
		}
	}
	
	static HashSet<Integer> set = new HashSet<>();
	
	static PriorityQueue<Node> maxPQ = new PriorityQueue<>((a, b) -> {
		if (a.level == b.level) return b.p - a.p;
		return b.level - a.level;
	});
	
	static PriorityQueue<Node> minPQ = new PriorityQueue<>((a, b) -> {
		if (a.level == b.level) return a.p - b.p;
		return a.level - b.level;
	});
	
	static int[] levels = new int[100001];
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			maxPQ.add(new Node(p,l));
			minPQ.add(new Node(p,l));
			set.add(p);
			levels[p] = l;
		}
		
		
		m = Integer.parseInt(br.readLine());
		
		for (int i = 0 ; i < m ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			String order = st.nextToken();
			
			if (order.equals("add")) {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				maxPQ.add(new Node(p,l));
				minPQ.add(new Node(p,l));
				set.add(p);
				levels[p] = l;
			}
			if (order.equals("recommend")) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					while(true) {
						Node cur = maxPQ.peek();
						if (set.contains(cur.p) && levels[cur.p] == cur.level){
							sb.append(cur.p).append("\n");
							break;
						}
						else maxPQ.poll();
					}
				}
				if (x == -1) {
					while(true) {
						Node cur = minPQ.peek();
						if (set.contains(cur.p) && levels[cur.p] == cur.level){
							sb.append(cur.p).append("\n");
							break;
						}
						else minPQ.poll();
					}

				}
			}
			if (order.equals("solved")) {
				int p = Integer.parseInt(st.nextToken());
				set.remove(p);
			}
		}
		
		System.out.print(sb.toString());
	}
	
}