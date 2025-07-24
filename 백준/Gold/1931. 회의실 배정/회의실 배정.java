import java.io.*;
import java.util.*;

public class Main {
    static class Meeting{
        int start;
        int end;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Meeting> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meeting(start, end));
        }

        list.sort((a, b) -> {
            if (a.end == b. end) return a.start - b.start;
            return a.end - b.end;
        });

        int count = 0;
        int lastend = 0;
        for (Meeting m : list) {
            if (m.start >= lastend) {
                count++;
                lastend = m.end;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }
}