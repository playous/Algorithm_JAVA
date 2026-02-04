import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int name;
		int level;
		public Node (int name, int level) {
			this.name = name;
			this.level = level;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        List<Integer>[] tree = new List[n + 1];
        for (int i = 1; i <= n ; i ++){
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 1 ; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
           
            tree[a].add(b);
            tree[b].add(a);
        }
        
        int leaf = 0;
        
        
        boolean[] visited = new boolean[n+1];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(1, 0));
        visited[1] = true;
        
        while(!q.isEmpty()) {
        	Node cur = q.poll();
        	int name = cur.name;
        	int level = cur.level;
        	
        	if (tree[name].size() == 1 && name != 1 ) {
        		leaf += level;
        		continue;
        	}
        	
        	for (int next : tree[name]) {
        		if(!visited[next]) {
        			q.add(new Node(next, level + 1));
        			visited[next] = true;
        		}
        	}
        }
        
        System.out.print(leaf % 2 == 1 ? "Yes" : "No");
    }
}
