import java.io.*;
import java.util.*;

public class Main {

    public static class Node{
        int weight;
        int value;
        Node(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();

        for (int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Node(w, v));
        }

        int[] dp = new int[k + 1];

        for (Node cur : list){
            int w = cur.weight;
            int v = cur.value;

            for (int i = k ; i >= w ; i --){
                dp[i] = Math.max(dp[i], dp[i - w] + v);
            }
        }

        System.out.println(dp[k]);

    }
}