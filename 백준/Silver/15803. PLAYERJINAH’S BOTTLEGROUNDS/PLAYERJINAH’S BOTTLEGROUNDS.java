import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] x = new int[3];
        int[] y = new int[3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;

        if((y[1] - y[0]) * (x[2] - x[1]) == (x[1] - x[0]) * (y[2] - y[1])) {
            count++;
        }
        if((y[1] - y[0]) * (x[2] - x[0]) == (x[1] - x[0]) * (y[2] - y[0])) {
            count++;
        }
        if((y[2] - y[1]) * (x[2] - x[0]) == (x[2] - x[1]) * (y[2] - y[0])) {
            count++;
        }
        if (count == 3) {
            sb.append("WHERE IS MY CHICKEN?");
        }
        else {
            sb.append("WINNER WINNER CHICKEN DINNER!");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}