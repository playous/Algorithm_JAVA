import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] weight = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        int[] boxes = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight);
        Arrays.sort(boxes);

        int[] maxCarry = new int[n];

        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (boxes[j] > weight[i]) {
                    break;
                }
            }
            maxCarry[i] = j - 1;
        }

        int answer = 0;
        boolean[] carried = new boolean[m];

        if (maxCarry[n - 1] != m - 1) {
            answer = -1;
        }
        else {
            int count = m;
            while (count > 0) {
                for (int i = 0; i < n; i++) {
                    if(maxCarry[i] < 0) continue;
                    int j;
                    for (j = maxCarry[i]; j >= 0; j--) {
                        if (!carried[j]) {
                            carried[j] = true;
                            maxCarry[i] = j - 1;
                            count--;
                            break;
                        }
                    }
                }
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}