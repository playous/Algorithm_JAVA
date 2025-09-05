import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        
        int turn1 = n - 1;
        int turn2 = n;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0){
                turn1 = i - 1;
                turn2 = i;
                break;
            }
        }

        int answer = 0;

        for (int i = 0; i <= turn1; i++) {
            if (i == turn1) answer += arr[i];
            else {
                int cur = arr[i] * arr[i + 1];
                if (cur == arr[i]) answer += arr[i] + 1;
                else answer += cur;
                i += 1;
            }
        }

        for (int i = n - 1; i >= turn2; i--) {
            if (i == turn2) answer += arr[i];
            else {
                answer += arr[i] * arr[i - 1];
                i -= 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
