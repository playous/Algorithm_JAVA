import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] count = new int[1000001];
        int answer = 0;

        int left = 0;
        int right = 0;

        count[arr[0]]++;

        while (true){
            answer = Math.max(right - left, answer);

            if (right == n ) break;
            if (count[arr[right]] > k){
                count[arr[left]]--;
                left++;
            }
            else {
                right++;
                if (right < n) count[arr[right]]++;
            }
        }

        System.out.println(answer);
    }

}