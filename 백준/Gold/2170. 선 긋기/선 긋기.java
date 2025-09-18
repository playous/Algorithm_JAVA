import java.io.*;
import java.util.*;

public class Main {
    static class Line{
        int x;
        int y;
        public Line(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Line> list = new ArrayList<>();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Line(x,y));
        }

        list.sort((a,b) -> {
            if (a.x == b.x) return a.y - b.y;
            return a.x - b.x;
        });


        int min = list.get(0).x;
        int max = list.get(0).y;
        int prev = list.get(0).x;

        for (int i = 0; i < list.size(); i++) {
            Line line = list.get(i);
            if (line.x == prev) max = Math.max(line.y, max);
            else {
                answer += Math.abs(max - min);
                min = Math.max(line.x, max);
                max = Math.max(line.y, max);
                prev = line.x;
            }
        }
        if (max > min) answer += max - min;

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}

