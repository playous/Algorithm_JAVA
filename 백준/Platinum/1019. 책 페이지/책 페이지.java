import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] count = new int[11];

        for (int i = 0; i < 10; i++) {
            count[i] = calc(n, i);
        }
        for (int i = 0; i < 10; i++) {
            bw.write(count[i] + " ");
        }
        bw.flush();
    }

    static int calc(int n, int target) {
        int count = 0;
        int position = 1;

        while (position <= n) {
            /*
            숫자를 세 구역으로 나눈후, 자리수 마다 경우의 수를 구하여 합산
             */
            int top = n / (position * 10);
            int mid = (n / position) % 10;
            int bot = n % position;

            if (target == 0) {
                if (top == 0) {
                    count += 0;
                } else {
                    if (mid == 0) {
                        count += (top - 1) * position + bot + 1;
                    } else {
                        count += top * position;
                    }
                }
            } else {
                if (mid < target) {
                    count += top * position;
                } else if (mid == target) {
                    count += top * position + bot + 1;
                } else {
                    count += (top + 1) * position;
                }
            }
            position *= 10;
        }
        return count;
    }
}
