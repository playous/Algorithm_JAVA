import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 100; i++) {
            list.add(i);
        }

        for (int i = 100; i < 1000; i++) {
            char[] ch = String.valueOf(i).toCharArray();
            if (ch[0] - ch[1] == ch[1] - ch[2]) {
                list.add(i);
            }
        }
        Collections.sort(list);

        int answer = 0;

        for (int num : list) {
            if (num > n) {
                break;
            }
            answer++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

}
