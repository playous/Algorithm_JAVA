import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T ; t++){
         	char[] arr = br.readLine().toCharArray();
            int n = arr.length;
            int answer = 0;
            char flag = '1';
            
            for (int i = 0; i < n; i ++){
                if(arr[i] == flag) {
                    answer++;
                    flag = flag == '1' ? '0' : '1' ; 
                }
            }
            
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        
        System.out.println(sb.toString());
	}
}