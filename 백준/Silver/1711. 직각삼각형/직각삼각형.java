import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    Point p1 = list.get(i);
                    Point p2 = list.get(j);
                    Point p3 = list.get(k);
                    if (check1(p1, p2, p3)) {
                      answer++;
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static boolean check1(Point a, Point b, Point c) {
        return check2(a, b, c) || check2(b, a, c) || check2(c, a, b);
    }

    static boolean check2(Point center, Point p1, Point p2) {
        long v1x = p1.x - center.x;
        long v1y = p1.y - center.y;
        long v2x = p2.x - center.x;
        long v2y = p2.y - center.y;

        return (v1x * v2x + v1y * v2y) == 0;
    }
}