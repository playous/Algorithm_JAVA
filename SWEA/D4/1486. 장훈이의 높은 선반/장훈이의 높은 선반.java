import java.util.*;
import java.io.*;

class Solution
{
    static int answer;
    static int n, b;
    static int[] arr;
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            arr = new int[n];
            
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            
            for (int i = 0; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            
            answer = sum - b;
            
            for (int i = 1; i <= n ; i ++){
                calc(0, i, sum);
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.toString());
	}
    
    public static void calc(int idx, int count, int sum){
        if (sum < b) return;
        if (count == 0){
            answer = Math.min(answer, calc2(sum));
            return;
        }
                
        for (int i = idx ; i < n; i++){
            sum -= arr[i];
            calc(i +1, count - 1, sum);
            sum += arr[i];
        }
    }
    
    public static int calc2(int sum){
        return sum - b;
    }
}