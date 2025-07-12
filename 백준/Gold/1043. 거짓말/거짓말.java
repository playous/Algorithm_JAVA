import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] heard = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        int knowNum = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowNum; i++) {
            heard[Integer.parseInt(st.nextToken())] = true;
        }

        List<Set<Integer>> answerSet = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int[] ids = new int[k];
            boolean check = false;
            for (int j = 0; j < k; j++) {
                int id = Integer.parseInt(st.nextToken());
                if (heard[id]) check = true;
                ids[j] = id;
            }
            if (!check) {
                Set<Integer> set = new HashSet<>();
                for (int j : ids) {
                    set.add(j);
                }
                answerSet.add(set);
            }
            else {
                for (int j : ids) {
                    heard[j] = true;
                }
                boolean changed = true;
                while (changed) {
                    changed = false;

                    for (int j = answerSet.size() - 1; j >= 0; j--) {
                        Set<Integer> set = answerSet.get(j);
                        boolean hasKnower = false;

                        for (int person : set) {
                            if (heard[person]) {
                                hasKnower = true;
                                break;
                            }
                        }

                        if (hasKnower) {
                            for (int person : set) {
                                if (!heard[person]) {
                                    heard[person] = true;
                                    changed = true;
                                }
                            }
                            answerSet.remove(j);
                        }
                    }
                }

            }
        }
        bw.write(String.valueOf(answerSet.size()));
        bw.flush();
    }
}
