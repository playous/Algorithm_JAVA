import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {1, -1, 0, 1};
    static int[] dc = {0, 1, 1, 1};
    static int result;
    static int node;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        map = new int[19][19];

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = false;
        for (int i = 0 ; i < 19; i++) {
            for (int j = 0 ; j < 19; j++) {
                if (map[i][j] != 0) {
                    node = map[i][j];
                    for (int k = 0; k < 4; k++) {
                        result = 0;
                        check(k, i, j, 1);
                        if (result == 5){
                            if (i - dr[k] >= 0 && j - dc[k] >= 0 && i - dr[k] < 19 && j - dc[k] < 19) {
                                if (map[i - dr[k]][j - dc[k]] == node) {
                                    continue;
                                }
                            }
                            sb.append(node).append("\n").append(i + 1).append(" ").append(j + 1);
                            flag = true;
                            break;
                        }
                    }
                    if (flag){
                        break;
                    }
                }
            }
            if (flag){
                break;
            }
        }
        if (!flag) sb.append("0");

        bw.write(sb.toString());
        bw.flush();
    }

    static void check(int type, int r, int c, int count) {
        int nr = r + dr[type];
        int nc = c + dc[type];
        if (nr >= 0 && nr < 19 && nc >= 0 && nc < 19) {
            if(count == 5){
                if (map[nr][nc] != node){
                    result = 5;
                    return;
                }
                else {
                    result = 6;
                    return;
                }
            }
            if (map[nr][nc] == node) {
                check(type, nr, nc, count + 1);
            }
        }
        else {
            result = count;
        }
    }

}

