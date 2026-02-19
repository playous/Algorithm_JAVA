import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        calc(0, new ArrayList<>());
    }

    public static void calc(int cnt, List<Integer> list){
        if(cnt == m){
            for (int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n ; i ++){
            if (visited[i]) continue;
            visited[i] = true;
            list.add(i);
            calc(cnt + 1, list);
            visited[i] = false;
            list.remove((Object)i);
        }

    }
}