import java.util.*;
import java.io.*;

public class Main{

    static int n, m ;
    static int answer = 0;
    static int[][] arr = new int[2][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                calc(j,arr[i][j],1);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();

    }

    static void calc(int prev, int now, int count){
        if(count == n) {
            if(now >= m) answer++;
            return;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                int point = arr[i][j];
                if(j == prev) point /= 2;
                calc(j, now + point, count + 1);
            }
        }
    }
}