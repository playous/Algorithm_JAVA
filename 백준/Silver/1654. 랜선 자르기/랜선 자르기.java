import java.util.*;
import java.io.*;

class Main{
	
	static int[] arr;
	static int n , k;
	
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
       
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        arr = new int[k];
        long sum = 0;
        
        for (int i = 0; i < k ; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	sum += arr[i];
        }
        
        
        long left = 1;
        long right = sum;
        
        long answer = 0;
        
        while (left <= right) {
        	long mid = (left + right) / 2;
        	int count = getCount(mid);
        	
        	if (count < n) {
        		right = mid - 1;
        	}
        	if (count >= n) {
        		answer = Math.max(answer, mid);
        		left = mid + 1;
        	}
        }
       
        System.out.print(answer);
	}
	
	public static int getCount(long len) {
		int cnt = 0;
		for (int i = 0 ; i < k; i ++) {
			cnt += arr[i]/len;
		}
		return cnt;
	}
}

