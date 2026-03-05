import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int last = 0;

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int cur = arr[i];

            if (cur > last + 1) {
                answer = last + 1;
                break;
            }

            last += cur;
        }

        if (answer == 0) answer = last + 1;

        System.out.print(answer);
    }

}