import java.util.*;
import java.io.*;

class Solution{
    
	static int[] nums;
	static int n;
	static int max, min;
	
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int[] calc = new int[4];
			
			for (int i = 0; i < 4 ; i ++) {
				calc[i] = Integer.parseInt(st.nextToken());
			}
			
			nums = new int[n];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n ; i ++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			max = -Integer.MAX_VALUE;
			min = Integer.MAX_VALUE;

			calcs(calc, nums[0], 1);
			sb.append("#").append(t).append(" ").append(max-min).append("\n");
		}
        System.out.println(sb.toString());
	}
	
	public static void calcs(int[] calc, int prev, int next) {
		if (next == n) {
			if (prev > max) max = prev;
			if (prev < min) min = prev;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(calc[i] > 0) {
				calc[i]--;
				int sum1 = calcs1(i, prev, next);
				calcs(calc, sum1, next+1);
				calc[i]++;
			}
		}
	}
    
	public static int calcs1(int i, int prev, int next) {
		if(i == 0) return prev + nums[next];
		if(i == 1) return prev - nums[next];
		if(i == 2) return prev * nums[next];
		if(i == 3) return prev / nums[next];
		return 0;
	}
}