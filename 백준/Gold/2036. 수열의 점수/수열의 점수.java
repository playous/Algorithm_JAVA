import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Long> list = new ArrayList<>();

        int plus = 0;
        int zero = 0;
        int minus = 0;

        long answer = 0;

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            if (num == 1) {
                answer += 1;
                continue;
            }
            if (num < 0) minus++;
            if (num > 0) plus++;
            if (num == 0) zero++;
            list.add(num);
        }
        Collections.sort(list);


        while (minus > 1) {
            long a = list.get(0);
            long b = list.get(1);
            if (b < 0){
                list.remove(0);
                list.remove(0);
                answer += (a * b);
                minus -= 2;
            }
        }

        if (minus == 1){
            if (zero == 0){
                answer += list.get(0);
            }
            list.remove(0);
        }

        list.sort(Collections.reverseOrder());

        while (plus > 1) {
            long a = list.get(0);
            long b = list.get(1);

            if (b > 1){
                list.remove(0);
                list.remove(0);
                answer += (a * b);
                plus -= 2;
            }
        }
        if (zero > 0){
            list.remove(list.size()-1);
        }
        if (plus == 1){
            answer += list.get(0);
        }

        bw.write(String.valueOf(answer));

        bw.flush();
    }

}
