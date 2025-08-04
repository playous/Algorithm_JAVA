import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> d = new ArrayDeque<>();
        int[] list = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            d.addLast(i);
        }
        int answer = 0;
        for (int i : list) {
            Deque<Integer> d1 = new ArrayDeque<>();
            Deque<Integer> d2 = new ArrayDeque<>();
            for (int num : d){
                d1.addLast(num);
                d2.addLast(num);
            }
            int count1 = 0;
            int count2 = 0;
            while (d1.peekFirst() != i) {
                d1.addLast(d1.removeFirst());
                count1++;
            }
            while (d2.peekFirst() != i) {
                d2.addFirst(d2.removeLast());
                count2++;
            }


            if (count1 < count2) {
                d = d1;
                answer += count1;
            }
            else {
                d = d2;
                answer += count2;
            }
            d.removeFirst();
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
