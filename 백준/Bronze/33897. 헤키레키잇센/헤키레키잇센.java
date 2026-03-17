import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;
        int count = 1;
        int max = 1;
        int prev = arr[0];

        for (int i = 1; i < n ; i ++){
            if (arr[i] >= prev){
                cnt++;
            }
            else {
                max = Math.max(max, cnt);
                cnt = 1;
                count++;
            }
            prev = arr[i];
        }

        max = Math.max(max, cnt);

        System.out.print(count + " " + max);

    }

}