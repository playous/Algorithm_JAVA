import java.io.*;
import java.util.*;

public class Main {
    static class Score{
        int test1;
        int test2;
        boolean passed;
        public Score(int test1, int test2, boolean passed) {
            this.test1 = test1;
            this.test2 = test2;
            this.passed = passed;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int q = 0; q < t; q++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;

            List<Score> scores = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                scores.add(new Score(a, b, false));
            }

            // 테스트 1
            scores.sort((a,b) -> a.test1 - b.test1);
            int minTest2 = Integer.MAX_VALUE;
            for (int i = 0 ; i < scores.size() ; i++) {
                Score s = scores.get(i);
                if (s.test2 <= minTest2) {
                    minTest2 = s.test2;
                    s.passed = true;
                    answer++;
                }
            }

            // 테스트 2
            scores.sort((a,b) -> a.test2 - b.test2);
            int minTest1 = Integer.MAX_VALUE;
            for (int i = 0 ; i < scores.size() ; i++) {
                Score s = scores.get(i);
                if (s.test1 <= minTest1){
                    minTest1 = s.test1;
                    if (!s.passed) answer++;
                }
            }
            bw.write(answer + "\n");
        }

        bw.flush();
    }
}