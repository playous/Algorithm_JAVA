import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int[] arr = new int[100];
            int cnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100 ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            for (int i = 0 ; i < cnt; i ++){
                Arrays.sort(arr);
                if (arr[0] == arr[99]) break;
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);
            sb.append("#").append(test_case).append(" ").append(arr[99] - arr[0]).append("\n");   
		}
        bw.write(sb.toString());
        bw.flush();
        
	}
}