import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            boolean reverse = false;
            String s = br.readLine();
            int size = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            String arrStr = br.readLine();
            arrStr = arrStr.replace("[", "").replace("]", "").replace(",", " ");
            StringTokenizer st = new StringTokenizer(arrStr);
            while (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            s = s.replace("RR", "");
            for (char c : s.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse;
                }
                if (c == 'D'){
                    if (deque.isEmpty()) {
                        flag = false;
                        sb.append("error\n");
                        break;
                    }
                    if (reverse) deque.removeLast();
                    else deque.removeFirst();
                }
            }

            if (flag) {
                int k = deque.size();
                sb.append("[");
                if (!reverse){
                    for (int j = 0 ; j < k ; j++) {
                        sb.append(deque.pollFirst() + ",");
                    }
                }
                else {
                    for (int j = 0 ; j < k ; j++) {
                        sb.append(deque.pollLast() + ",");
                    }
                }
                if (k > 0 )sb.deleteCharAt(sb.length() - 1);
                sb.append("]\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}