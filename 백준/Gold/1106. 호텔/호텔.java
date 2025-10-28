import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main
{
    static class Node {
        int cost;
        int people;
        public Node(int cost, int people) {
            this.cost = cost;
            this.people = people;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            list.add(new Node(cost, people));
        }

        int[] dp = new int[c + 101];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = 100001;
        }

        for (int i = 0; i < n; i++) {
            int cost = list.get(i).cost;
            int people = list.get(i).people;

            for (int j = people; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - people] + cost);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = c; i < dp.length; i++) {
            answer = Math.min(answer, dp[i]);
        }

        bw.write(String.valueOf(answer));
        bw.flush();

    }
}