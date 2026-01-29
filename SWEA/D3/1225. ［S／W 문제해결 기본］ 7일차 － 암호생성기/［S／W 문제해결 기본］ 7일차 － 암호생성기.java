import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int t = 1; t <= 10 ; t++){
        	int n = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	int[] arr = new int[8];
        	
        	Deque<Integer> dq = new ArrayDeque<>();
        	
        	for (int i = 0; i < 8 ; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        		dq.addLast(arr[i]);
        	}
        	
        	int idx = 1;
        	
        	while (true) {
        		int num = dq.poll();
        		if (num - idx > 0) {
        			dq.addLast(num - idx);
        		}
        		else {
        			dq.addLast(0);
        			break;
        		}
        		idx++;
        		if (idx == 6) idx = 1;
        	}
        	
        	sb.append("#").append(t).append(" ");
        	
        	for (int i = 0; i < 8 ; i ++) {
        		sb.append(dq.poll() + " ");
        	}
        	sb.append("\n");
        }
        System.out.print(sb.toString());
	}
}
