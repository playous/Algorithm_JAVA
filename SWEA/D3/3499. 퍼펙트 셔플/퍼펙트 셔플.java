import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T ; t++){
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
      
            st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < n ; i ++){
                arr[i] = st.nextToken();
            }
            int mid = (n + 1) / 2;
            
            StringBuilder sb1 = new StringBuilder();
            
            for (int i = 0 ; i < mid ; i ++){
                sb1.append(arr[i]).append(" ");
                if(mid + i  < n){
                    sb1.append(arr[mid + i]).append(" ");
                }
            }
            sb.append("#").append(t).append(" ").append(sb1).append("\n");
        }
        System.out.print(sb.toString());
	}
}
