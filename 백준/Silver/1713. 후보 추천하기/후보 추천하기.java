import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> student = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(st.nextToken());
            student.put(k, student.getOrDefault(k, 0) + 1);
            if (list.size() == n && !list.contains(k)) {
                int min = 10000;
                int minidx = 0;
                int idx = 0;
                int minI = 0;
                for (int name : list) {
                    if (student.get(name) < min) {
                        min = student.get(name);
                        minidx = name;
                        minI = idx;
                    }
                    idx ++;
                }
                student.remove(minidx);
                list.remove(minI);
            }
            if (list.size() < n  && !list.contains(k)) {
                list.add(k);
            }
        }


        list.sort((a, b) -> a- b);
        for (int i : list) {
            System.out.print(i+ " ");
        }
        bw.flush();
    }

}