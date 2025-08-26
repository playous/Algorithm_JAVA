import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] count = new int[d + 1];
        int count1 = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k; i++) {
            count[arr[i]]++;
            if(count[arr[i]] == 1){
                count1++;
            }
            int flag = count[c] == 0 ? 1 : 0;
            answer = Math.max(answer, count1 + flag);
        }

        for (int i = 1; i < n; i++) {
            count[arr[i-1]]--;
            count[arr[(i + k - 1) % n]]++;
            if (arr[i - 1] != arr[(i + k - 1) % n]) {
                if(count[arr[i-1]] == 0){
                    count1--;
                }
                if(count[arr[(i + k - 1) % n]] == 1){
                    count1++;
                }
            }
            int flag = count[c] == 0 ? 1 : 0;
            answer = Math.max(answer, count1 + flag);
        }
        System.out.println(answer);
        bw.flush();
    }
}
