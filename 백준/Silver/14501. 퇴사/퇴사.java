import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int time;
        int money;
        Node(int time, int money) {
            this.time = time;
            this.money = money;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            list.add(new Node(time, money));
        }

        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            Node cur = list.get(i);
            int time = cur.time;
            int money = cur.money;
            if (time + i > n) continue;
            int max = 0;
            for (int j = 1 ; j <= i ; j++) {
                max = Math.max(max, dp[j]);
            }
            dp[i + time] = Math.max(max + money, dp[i + time]);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}