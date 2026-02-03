import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];
        
        for (int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = n - 1;
        int answer = 0;
        
        while (left < right){
            int sum = arr[left] + arr[right];
            if (sum == m){
                left++;
                right--;
                answer++;
            }
            else if (sum < m){
                left++;
            }
            else if (sum > m){
                right--;
            }
        }
        
        System.out.print(answer);
	}
}
