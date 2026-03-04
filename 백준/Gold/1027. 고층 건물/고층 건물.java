import java.util.*;
import java.io.*;

public class Main {
	
	static int n ;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int answer = 0;
		
		
		for (int i = 0; i < n ; i ++) {
			answer = Math.max(answer, left(i) + right(i));
		}
		
		System.out.print(answer);
		
	}
	
	public static int left(int idx) {
		int cnt = 0;
		
		int H = arr[idx];
		
		long prevDX = 1;
		long prevDY = 1000000001;
		
		long prevUX = 51;
		long prevUY = 1;

		boolean hasHigh = false;
		
		for (int i = idx - 1; i >= 0 ; i--) {
			int curH = arr[i];
			
			long curX = Math.abs(idx - i);
			long curY = Math.abs(H - curH);
			
			if (curH > H) {
				if (canUp(prevUX, prevUY, curX, curY)) {
					cnt++;
					prevUX = curX;
					prevUY = curY;
				}
				hasHigh = true;
			}
			else if (curH == H) {
				if (!hasHigh) {
					hasHigh = true;
					prevUX = curX;
					prevUY = curY;
					cnt++;
				}
			}
			else if (curH < H && !hasHigh) {
				if (canDown(prevDX, prevDY, curX, curY)) {
					cnt++;
					prevDX = curX;
					prevDY = curY;
				}	
			}
		}
		
		return cnt;
	}
	
	
	public static int right(int idx) {
		int cnt = 0;
		
		int H = arr[idx];
		
		long prevDX = 1;
		long prevDY = 1000000001;
		
		long prevUX = 51;
		long prevUY = 1;
		
		boolean hasHigh = false;

		for (int i = idx + 1; i < n ; i++) {
			int curH = arr[i];
			
			long curX = Math.abs(idx - i);
			long curY = Math.abs(H - curH);

			
			if (curH > H) {
				if (canUp(prevUX, prevUY, curX, curY)) {
					cnt++;
					prevUX = curX;
					prevUY = curY;
				}
				hasHigh = true;
			}
			else if (curH == H) {
				if (!hasHigh) {
					hasHigh = true;
					prevUX = curX;
					prevUY = curY;
					cnt++;
				}
			}
			else if (curH < H && !hasHigh) {
				if (canDown(prevDX, prevDY, curX, curY)) {
					cnt++;
					prevDX = curX;
					prevDY = curY;
				}	
			}
			
		}
		
		return cnt;
	}
	
	public static boolean canUp(long x1, long y1, long x2, long y2) {
		return x1 * y2 > y1 * x2;
	}
	
	public static boolean canDown(long x1, long y1, long x2, long y2) {
		return y1 * x2 > x1 * y2;
		
	}
	
	
}