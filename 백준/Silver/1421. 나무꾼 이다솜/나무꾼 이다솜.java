import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] tree = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, tree[i]);
        }

        long answer = 0;

        for (int i = 1; i <= max; i++) {
            int chop = 0;
            int count = 0;
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if (tree[j] < i) continue;
                int k = tree[j] / i;
                count = k;
                chop = k;
                if (tree[j] % i == 0){
                    chop -= 1;
                }
                int tmp = (count * i * w) - (chop * c);
                if (tmp > 0) {
                    sum += tmp;
                }
            }
            answer = Math.max(answer, sum);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}