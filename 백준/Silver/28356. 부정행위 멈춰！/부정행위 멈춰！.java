import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == 1){
            if (m == 1) sb.append("1\n");
            else sb.append("2\n");
            for (int i = 1; i <= m; i++) {
                sb.append((i % 2 == 0 ? 2 : i % 2) + " ");
            }
        }
        else if (m == 1){
            sb.append("2\n");
            for (int i = 1; i <= n; i++) {
                sb.append((i % 2 == 0 ? 2 : i % 2) + "\n");
            }
        }
        else {
            sb.append("4\n");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i % 2 == 1 && j % 2 == 1) {
                        sb.append("1" + " ");
                    }
                    if (i % 2 == 1 && j % 2 == 0) {
                        sb.append("2" + " ");
                    }
                    if (i % 2 == 0 && j % 2 == 1) {
                        sb.append("3" + " ");
                    }
                    if (i % 2 == 0 && j % 2 == 0) {
                        sb.append("4" + " ");
                    }
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

}