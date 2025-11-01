import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int prev = list.get(0);
        long first = 0;
        for (int i = 1; i < n; i++) {
            first += list.get(i) - prev;
        }

        long answer = first;
        int house = list.get(0);

        for (int i = 1; i < n; i++) {
            int cur = list.get(i);
            int diff = cur - prev;
            long sum = first + (i * diff) - (n - i) * diff;
            if (sum < answer) {
                answer = sum;
                house = cur;
            }
            first = sum;
            prev = cur;
        }

        bw.write(String.valueOf(house));
        bw.flush();
    }

}

