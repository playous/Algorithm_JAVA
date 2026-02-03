import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1 ; t <= T ; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < n ; i ++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(arr);
            
            int left = 0;
            int right = n - 1;
            int answer = -1;
            
            while (left < right){
                int sum = arr[left] + arr[right];
                if(sum <= m){
                    answer = Math.max(answer, sum);
                    left++;
                }
                if(sum > m){
                    right--;
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}