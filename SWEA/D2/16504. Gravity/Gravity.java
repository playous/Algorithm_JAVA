import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t ++){
            int n = Integer.parseInt(br.readLine());
            boolean[][] map = new boolean[n][100];
            
            st = new StringTokenizer(br.readLine());
            
            int max = 0;
            
            for (int i = 0 ; i < n ; i ++){
                int h = Integer.parseInt(st.nextToken());
                max = Math.max(max, h);
                for (int j = 0 ; j < h ; j ++){
                    map[i][j] = true;
                }
            }
            
            int answer = 0;
            
            for (int j = 0; j < max; j ++){
                int start = 0;
                int res = 0;
                
                for (int i = 0 ; i < n ; i++){
                    if(map[i][j]) {
                        start = i;
                        break;
                    }
                }
                int cnt = 0;
                for (int i = start + 1; i < n ; i++){
                    if(map[i][j]) cnt++;
                }
                res = n - start  - cnt - 1;
                answer = Math.max(answer, res);
            }
            
            sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
        
        System.out.println(sb.toString());
    }
}