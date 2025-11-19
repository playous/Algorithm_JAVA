import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < 10; t++) {
            int n = Integer.parseInt(br.readLine());
            int end = 0;
            int[][] map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (i == 99) {
                        if (map[i][j] == 2) end = j;
                    }
                }
            }
            for (int i = 99 ; i > 0 ; i --){
                if (end - 1 >= 0 && map[i][end-1] == 1){
                    while(map[i][end-1] == 1){
                        end--;
                        if (end == 0) break;
                    }
                }
                else if (end + 1 <= 99 && map[i][end+1] == 1){
                    while(map[i][end+1] == 1){
                        end++;
                        if (end == 99) break;
                    }
                }
            }
            sb.append("#").append(n).append(" ").append(end).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}