import java.util.*;
import java.io.*;

public class Main{
    static int[][] dmove = {{0,1}, {-1, 0}, {0, -1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[] move = br.readLine().toCharArray();
        char[][] board = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                board[i][j] = '#';
            }
        }
        int x = 50;
        int y = 50;
        int max_x = x;
        int min_x = x;
        int max_y = y;
        int min_y = y;
        board[x][y] = '.';
        int moveidx = 0;
        for (int i = 0 ; i < n ; i++){
            char c = move[i];
            if (c == 'F') {
                x += dmove[moveidx][0];
                y += dmove[moveidx][1];
                board[x][y] = '.';
                if (x > max_x) max_x = x;
                if (x < min_x) min_x = x;
                if (y > max_y) max_y = y;
                if (y < min_y) min_y = y;
            }
            else if (c == 'R') moveidx++;
            else if (c == 'L') moveidx--;
            if (moveidx < 0) moveidx = 3;
            moveidx %= 4;
        }

        for (int i = min_y ; i <= max_y ; i++){
            for (int j = min_x ; j <= max_x ; j++){
                System.out.print(board[j][i]);
            }
            System.out.println();
        }
    }
}