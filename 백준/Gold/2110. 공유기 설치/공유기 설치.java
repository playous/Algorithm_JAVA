import java.io.*;
import java.util.*;

public class Main {
    static int n, c;
    static int[] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = 1000000000;
        int answer = 0;

        while (left <= right){
            int mid = (left + right) / 2;
            int count = canInstall(mid);
            if (count >= c){
                answer = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.print(answer);
    }

    // len 이상으로 설치 가능한 공유기 수
    public static int canInstall(int len){
        int cnt = 1;
        int prev = arr[0];

        for (int i = 1 ; i < n ; i ++){
            if (arr[i] - prev >= len) {
                cnt++;
                prev = arr[i];
            }
        }
        return cnt;
    }
}