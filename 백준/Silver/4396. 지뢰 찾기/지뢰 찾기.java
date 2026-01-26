import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, -1, -1, 0, 0, 1 ,1 ,1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static char[][] map;
    static char[][] answerMap;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        answerMap = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        boolean hasBomb = false;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                answerMap[i][j] = s.charAt(j);
                if (answerMap[i][j] == 'x' && map[i][j] == '*') hasBomb = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (answerMap[i][j] == 'x') {
                    change(i, j);
                }
            }
        }

        if (hasBomb) {
            for (int i = 0 ; i < n ; i ++){
                for (int j = 0 ; j < n ; j ++){
                    if (map[i][j] == '*')
                        answerMap[i][j] = '*';
                }
            }
        }


        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j++){
                System.out.print(answerMap[i][j]);
            }
            System.out.println();
        }
    }

    public static void change(int r, int c){
        int num = 0;
        for (int i = 0 ; i < 8 ; i ++){
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if (nextR >= 0 && nextC >= 0 && nextR < n && nextC < n){
                if (map[nextR][nextC] =='*') num++;
            }
        }
        answerMap[r][c] = (char)(num + '0');
    }
}