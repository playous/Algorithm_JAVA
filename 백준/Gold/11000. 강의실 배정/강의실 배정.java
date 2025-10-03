import java.util.*;
import java.io.*;

class Main {
    static class HomeWork{
        int start;
        int end;
        public HomeWork(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());


        List<HomeWork> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new HomeWork(s, e));
        }

        list.sort((a, b) -> {
            if (a.start != b.start) {
                return a.start - b.start;
            }
            return a.end - b.end;
        });
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(list.get(0).end);
        list.remove(0);

        for (HomeWork w : list) {
            if (q.peek() <= w.start) {
                q.poll();
            }
            q.add(w.end);
        }

        bw.write(String.valueOf(q.size()));
        bw.flush();
    }
}