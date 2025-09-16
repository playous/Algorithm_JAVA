import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer>[] list;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < n && !flag ; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            backTrack(i, 1, visited);
        }

        bw.write(flag ? "1" : "0");
        bw.flush();
    }

    static void backTrack(int cur,  int count, boolean[] visited) {
        if (count == 5) {
            flag = true;
            return;
        }
        for (int num : list[cur]) {
            if (!visited[num]) {
                visited[num] = true;
                backTrack(num, count + 1, visited);
                visited[num] = false;
            }
        }
    }
}

