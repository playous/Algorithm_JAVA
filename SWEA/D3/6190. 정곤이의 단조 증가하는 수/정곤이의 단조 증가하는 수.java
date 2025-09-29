import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            HashSet<Integer> set = new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < n ; i ++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n ; i ++){
                int now = arr[i];
                for (int j = i + 1 ; j < n ; j++){
                    if (isUp(now * arr[j])) set.add(now * arr[j]);
                }
            }
            
            int max = -1;
            for (int num : set){
                if (num > max) max = num;
            }
            sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
        
        bw.write(sb.toString());
        bw.flush();
	}
    
    static boolean isUp(int num){
        int prev = num % 10;
        num /= 10;
        while (num > 0){
            int now = num % 10;
            if (now > prev) return false;
            prev = now;
            num /= 10;
        }
        return true;
    }
}