import java.util.*;
import java.io.*;

public class Main{
	
	static class Node {
        int data;
        int time;
        Node(int data){
            this.data = data;
        }
        Node(int data, int time){
        	this.data = data;
        	this.time = time;
        }
    }
	public static void main(String args[]) throws IOException{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        
	        st = new StringTokenizer(br.readLine());
	        
	        int n = Integer.parseInt(st.nextToken());
	        int m = Integer.parseInt(st.nextToken());
	        
	        
	        List<Node> list = new ArrayList<>();
	        
	        st = new StringTokenizer(br.readLine());
	        for (int i = 0 ; i < n ; i ++){
	            int data = Integer.parseInt(st.nextToken());
	            list.add(new Node(data));
	        }
	        
	        st = new StringTokenizer(br.readLine());
	        int max = 0;
	        for (int i = 0 ; i < n ; i ++){
	            int time = Integer.parseInt(st.nextToken());
	            max += time;
	            list.get(i).time = time;
	        }
	        
	        int[] dp = new int[max + 1];
	        list.sort((a, b) -> a.data - b.data);
	        
	        
	        for (int i = 0; i < n; i++){
	            Node cur = list.get(i);
	            int data = cur.data;
	            int time = cur.time;
	            
	            for (int j = max ; j >= 0 ; j--){
	                if (j < time) continue;
	                dp[j] = Math.max(dp[j], dp[j - time] + data);
	                
	               
	            }
	        }
	        
	        for (int i = 0 ; i <= max; i ++ ) {
	        	if(dp[i] >= m) {
	        		System.out.println(i);
	        		break;
	        	}
	        }
	  }
}
