import java.io.*;
import java.util.*;

public class Main {
    static boolean[] know;
    static HashSet<Integer>[] set;

    static class People{
        int name;
        int level;
        public People(int name, int level){
            this.name = name;
            this.level = level;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        set = new HashSet[n + 1];

        for (int i = 1; i <= n; i++) {
            set[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            set[a].add(b);
            set[b].add(a);
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            Queue<People> q = new ArrayDeque<>();
            know = new boolean[n + 1];
            know[i] = true;
            for (int friend : set[i]) {
                q.add(new People(friend, 1));
                know[friend] = true;
            }
            while (!q.isEmpty()) {
                People people = q.poll();
                int level = people.level;
                int name = people.name;
                cnt += level;
                for (int friend : set[name]) {
                    if(!know[friend]) {
                        q.add(new People(friend, level + 1));
                        know[friend] = true;
                    }
                }
            }
            if(cnt < min){
                min = cnt;
                answer = i;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}