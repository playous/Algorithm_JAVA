import java.io.*;
import java.util.*;

public class Main {
    static class Member{
        int name;
        int level;
        public Member(int name, int level){
            this.name = name;
            this.level = level;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Member>[] list = new List[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1) break;
            list[a].add(new Member(b,1));
            list[b].add(new Member(a,1));
        }

        int[] answer = new int[n + 1];
        int min = 50;
        for (int i = 1; i <= n; i++) {
            Queue<Member> q = new ArrayDeque<>();
            boolean[] friend = new boolean[n+1];
            friend[i] = true;

            for (Member m : list[i]) {
                q.add(m);
                friend[m.name] = true;
            }

            while (!q.isEmpty()) {
                Member member = q.poll();
                int name = member.name;
                int level = member.level;
                answer[i] = Math.max(answer[i], level);
                for (Member m : list[name]) {
                    if (!friend[m.name]) {
                        q.add(new Member(m.name,level+1));
                        friend[m.name] = true;
                    }
                }
            }
            min = Math.min(min,answer[i]);
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (answer[i] == min) count++;
        }
        bw.write(min + " " + count);
        bw.newLine();

        for (int i = 1; i <= n; i++) {
            if (answer[i] == min) bw.write(i + " ");
        }

        bw.flush();
    }
}