import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];
        
        for (int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int a = 0;
        int b = 0;
        int min = Integer.MAX_VALUE;
        
        int left = 0;
        int right = n - 1;
        
        while (left < right){
            int sum = arr[left] + arr[right];
            
            if (sum == 0) {
            	a = arr[left];
            	b = arr[right];
            	break;
            }
            
            if (sum > 0){
                if (sum < min){
                    min = sum;
                    a = arr[left];
                    b = arr[right];
                }
                right--;
            }
            
            if (sum < 0){
                if (-sum < min){
                    min = -sum;
                    a = arr[left];
                    b = arr[right];
                }
                left++;
            }
        }
        System.out.print(a + " " + b);
	}
}
