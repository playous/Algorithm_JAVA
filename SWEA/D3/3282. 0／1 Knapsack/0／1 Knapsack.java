import java.io.*;
import java.util.*;

public class Solution {

    public static class Node{
        int v;
        int c;
        Node(int v, int c){
            this.v = v;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1 ; t <= T ; t++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] dp = new int[k + 1];

            List<Node> list = new ArrayList<>();
            for (int i = 0; i < n ; i++){
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.add(new Node(v,c));
            }

            for (int i = 0 ; i < list.size(); i++){
                int v = list.get(i).v;
                int c = list.get(i).c;
                for (int j = k ; j >= v ; j--){
                    dp[j] = Math.max(dp[j], dp[j - v] + c);
                }
            }

            sb.append("#").append(t).append(" ").append(dp[k]).append("\n");
        }
        System.out.println(sb.toString());
    }
}