import java.util.*;
import java.io.*;

public class Solution {

	static int n, m;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T ; t ++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			parents = new int[n + 1];
			
			for (int i = 1; i <= n ; i ++) {
				parents[i] = i;
			}
			
			
			for (int i = 0 ; i < m ; i ++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
				
			}
			
			HashSet<Integer> set = new HashSet<>();
			
			for (int i = 1 ; i <= n ; i ++) {
				int mom = findSet(i);
				set.add(mom);
				
			}
			
			sb.append("#").append(t).append(" ").append(set.size()).append("\n");
			
		}
		
		System.out.print(sb.toString());

	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) return false;
		
		parents[aRoot] = bRoot;
		return true;
	}
	
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}

}
