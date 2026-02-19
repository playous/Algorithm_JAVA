import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] answer;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            arr = new int[n];
            answer = new int[6];
            visited = new boolean[n];

            for (int i = 0 ; i < n ; i ++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            calc(0, 0);
            System.out.println();
        }
    }

    public static void calc(int idx , int cnt){
        if (cnt == 6){
            for (int i = 0 ; i < 6 ; i++){
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx ; i < n ; i++){
            if (!visited[i]){
                visited[i] = true;
                answer[cnt] = arr[i];
                calc(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}