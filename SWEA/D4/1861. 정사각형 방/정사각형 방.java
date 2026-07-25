import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node{
        int id;
        int r;
        int c;
        Node (int id, int r, int c){
            this.id = id;
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] map = new int[n][n];

            int[] dp = new int[n * n + 2];

            for (int i = 1; i <= n * n + 1; i ++){
                dp[i] = 1;
            }

            List<Node> list = new ArrayList<>();

            for (int i = 0 ; i < n ; i ++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0 ; j < n ; j ++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    list.add(new Node(map[i][j], i, j));
                }
            }

            Collections.sort(list, (a, b) -> b.id - a.id);

            for (Node node : list){
                int id = node.id;
                int r = node.r;
                int c = node.c;

                for (int i = 0 ; i < 4 ; i ++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n){
                        if(map[nr][nc] == id + 1){
                            dp[id] = dp[id + 1] + 1;
                        }
                    }
                }
            }

            int maxId = 0;
            int maxCnt = 0;

            for (int i = 1; i <= n * n ; i ++){
                if (dp[i] > maxCnt){
                    maxId = i;
                    maxCnt = dp[i];
                }
            }

            sb.append("#").append(t).append(" ").append(maxId).append(" ").append(maxCnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}