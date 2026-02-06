import java.util.*;
import java.io.*;

public class Solution {
    
    static int n, m, c;
    static int[][] map, maxMap;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1 ; t <= T ; t++) {
            st = new StringTokenizer(br.readLine());
            
			n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            map = new int[n][n];
            maxMap = new int[n][n -m + 1];
            
            
            for (int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n ; j++){
                	map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int answer = getMaxBenefit();
            
            sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	private static int getMaxBenefit() {
		
		makeMaxMap();
		
		return processCombination();
	}

	private static void makeMaxMap() {
		for (int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j <= n - m; j++) {
				subset(i, j, 0, 0, 0);
			}
		}
	}
	
	private static void subset(int i , int j ,int cnt, int sum, int powSum) {
		if (sum > c) return;
		
		if (cnt == m) {
			maxMap[i][j - m] = Math.max(maxMap[i][j - m], powSum);
			return;
		}
		
		// i, j 벌통 포함
		subset(i, j + 1, cnt + 1, sum + map[i][j] , powSum + (int)Math.pow(map[i][j], 2));
		
		// i, j 벌통 미포함
		subset(i, j + 1, cnt + 1, sum, powSum);
		
	}
	
	private static int processCombination() {	
		int aBenefit;
		int bBenefit;
	    int max = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n -m ; j++) {
				aBenefit = maxMap[i][j];
				bBenefit = 0;
				for (int i2 = 0; i2 < n; i2++) {
					int start = (i == i2) ? j + m : 0;
					for (int j2 = start; j2 <= n - m; j2 ++) {
						if(bBenefit < maxMap[i2][j2]) {
							bBenefit = maxMap[i2][j2];
						}
					}
				}
				if (max < aBenefit + bBenefit) {
					max = aBenefit + bBenefit;
				}
			}
		}	
		return max;
	}
}