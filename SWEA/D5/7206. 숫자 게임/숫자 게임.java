import java.io.*;
import java.util.*;

public class Solution {

    static String s;
    static int max;
    static int[] dp = new int[100001];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int num = 10; num <= 99999; num++) {
            max = 0;
            s = String.valueOf(num);
            slice(1, s.length(), new ArrayList<>());
            dp[num] = max;
        }

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int answer = dp[n];

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void slice(int idx, int len, List<Integer> list){
        for (int i = idx; i < len ; i++){
            list.add(i);
            calc(list, len);
            slice(i + 1, len, list);
            list.remove((Object)i);
        }
    }

    static void calc(List<Integer> list, int len){
        int sum = 1;
        int idx = 0;

        for (int nextSlice : list){
            sum *= Integer.parseInt(s.substring(idx, nextSlice));
            idx = nextSlice;
        }

        sum *= Integer.parseInt(s.substring(idx, len));
        max = Math.max(max, dp[sum] + 1);
    }

}