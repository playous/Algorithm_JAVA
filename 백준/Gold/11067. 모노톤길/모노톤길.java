import java.io.*;
import java.util.*;

public class Main {
    static class Location {
        int x;
        int y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Location> list = new ArrayList<>();
            List<Integer> answer = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Location(a, b));
                map.put(a, map.getOrDefault(a, 0) + 1);
            }

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int i = 0; i < m; i++) {
                answer.add(Integer.parseInt(st.nextToken()));
            }

            list.sort((a, b) -> a.x - b.x);
            List<Location> result = new ArrayList<>();
            int last = 0;
            int i = 0;

            while (i < list.size()) {
                int x = list.get(i).x;
                int count = map.get(x);

                List<Integer> yValues = new ArrayList<>();
                for (int j = i; j < i + count; j++) {
                    yValues.add(list.get(j).y);
                }

                int max = Collections.max(yValues);
                if (max == last) {
                    Collections.sort(yValues, Collections.reverseOrder());
                } else {
                    Collections.sort(yValues);
                }

                for (int y : yValues) {
                    result.add(new Location(x, y));
                }

                last = yValues.get(yValues.size() - 1);
                i += count;
            }

            for (int k : answer) {
                sb.append(result.get(k-1).x + " " + result.get(k-1).y + "\n");
            }
            t--;
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
