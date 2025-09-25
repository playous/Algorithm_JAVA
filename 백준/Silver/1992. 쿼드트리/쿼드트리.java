import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n  = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n ; i++){
            String s = br.readLine();
            for (int j = 0; j < n ; j++){
                map[i][j] = s.charAt(j) -'0';
            }
        }

        calc(0, 0, n);
        bw.write(sb.toString());
        bw.flush();
    }

    public static void calc(int x, int y , int size){
        int value = map[x][y];
        boolean flag = true;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != value){
                    flag = false;
                    break;
                }
            }
        }
        if (flag){
            sb.append(String.valueOf(value));
        }
        else {
            sb.append("(");
            int half = size / 2;
            calc(x, y, half);
            calc(x, y + half, half);
            calc(x + half, y, half);
            calc(x + half, y + half, half);
            sb.append(")");
        }

    }
}