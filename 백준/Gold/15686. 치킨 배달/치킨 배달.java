import java.io.*;
import java.util.*;

public class Main {
    static class XY {
        int x, y;
        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static List<XY> Chickens = new ArrayList<>();
    static List<XY> homes = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homes.add(new XY(i, j));
                } else if (map[i][j] == 2) {
                    Chickens.add(new XY(i, j));
                }
            }
        }

        backtrack(0, 0, new ArrayList<>());

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void backtrack(int start, int selected, List<XY> selectedCors) {
        if (selected == m) {
            int total = 0;
            for (XY home : homes) {
                int min = Integer.MAX_VALUE;

                for (XY cor : selectedCors) {
                    int distance = Math.abs(home.x - cor.x) + Math.abs(home.y - cor.y);
                    min = Math.min(min, distance);
                }

                total += min;
            }

            answer = Math.min(answer, total);
            return;
        }

        if (Chickens.size() - start < m - selected) {
            return;
        }

        for (int i = start; i < Chickens.size(); i++) {
            selectedCors.add(Chickens.get(i));
            backtrack(i + 1, selected + 1, selectedCors);
            selectedCors.remove(selectedCors.size() - 1);
        }
    }

}