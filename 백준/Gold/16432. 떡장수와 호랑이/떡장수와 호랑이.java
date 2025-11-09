import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static int n;
    static int[] result;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        list = new List[n];
        result = new int[n];
        visited = new int[10][n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        if (!dfs(0,0)) {
            bw.write("-1\n");
        } else {
            for (int i = 0; i < n; i++) {
                bw.write(result[i] + "\n");
            }
        }
        bw.flush();
    }

    static boolean dfs(int prev, int count) {
        if (count == n){
            return true;
        }

        if (visited[prev][count] != 0) {
            return visited[prev][count] == 1;
        }

        for (int next : list[count]) {
            if (prev != next) {
                result[count] = next;
                if (dfs(next, count + 1)){
                    visited[prev][count] = 1;
                    return true;
                }
            }
        }

        visited[prev][count] = -1;
        return false;
    }
}