import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 2000000000;
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            long sum = getTree(mid);
            if (sum >= m){
                answer = mid;
                left = mid + 1;
            }
            else if (sum < m){
                right = mid - 1;
            }
        }

        System.out.print(answer);
    }

    public static long getTree(int height){
        long sum = 0;
        for (int i = 0; i < n; i ++){
            if(arr[i] >= height){
                sum += arr[i] - height;
            }
        }
        return sum;
    }
}