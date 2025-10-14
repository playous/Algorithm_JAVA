import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new List[n + 1];
        int[] answer = new int[n + 1];
        answer[1] = 1;
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
        }
        for (int i = 2; i <= n; i++) {
            answer[i] = 1;
            for (int num : list[i]) {
                answer[i] = Math.max(answer[i], answer[num] + 1);
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(answer[i] + " ");
        }
        bw.flush();
    }
}
