import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= 10000; i++) {
            int sum = i;
            int cur = i;
            while (cur > 0) {
                sum += cur % 10;
                cur /= 10;
            }
            set.add(sum);
        }
        for (int i = 1; i <= 10000; i++) {
            if (!set.contains(i)) {
                bw.write(String.valueOf(i) + "\n");
            }
        }
        bw.flush();
    }
}

