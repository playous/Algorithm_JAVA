import java.io.*;
import java.util.*;

public class Main {
    static class Schedule {
        int start, end;

        Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Schedule> list = new ArrayList<>();

        boolean[][] calendar = new boolean[366][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Schedule(s, e));
        }

        list.sort((a, b) -> {
            if (a.start != b.start) {
                return a.start - b.start;
            }
            return (b.end - b.start) - (a.end - a.start);
        });

        for (Schedule schedule : list) {
            int level = 1;
            while (true) {
                boolean flag = true;

                for (int day = schedule.start; day <= schedule.end; day++) {
                    if (calendar[day][level]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int day = schedule.start; day <= schedule.end; day++) {
                        calendar[day][level] = true;
                    }
                    break;
                }

                level++;
            }
        }

        int[] maxHeight = new int[366];
        for (int day = 1; day <= 365; day++) {
            for (int level = 1; level <= n; level++) {
                if (calendar[day][level]) {
                    maxHeight[day] = level;
                }
            }
        }

        int answer = 0;
        int start = -1;

        for (int i = 1; i <= 366; i++) {
            if (i > 365 || maxHeight[i] == 0) {
                if (start != -1) {
                    int max = 0;
                    for (int j = start; j < i; j++) {
                        max = Math.max(max, maxHeight[j]);
                    }
                    int width = i - start;
                    answer += max * width;
                    start = -1;
                }
            } else {
                if (start == -1) {
                    start = i;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
