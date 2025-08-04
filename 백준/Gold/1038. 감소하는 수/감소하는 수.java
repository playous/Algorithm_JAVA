import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if(n == 0){
            bw.write(String.valueOf(0));
            bw.flush();
            return;
        }

        List<Long> list = new ArrayList<>();
        List<Long>[] nums = new List[10];

        for (int i = 0; i < 10; i++) {
            nums[i] = new ArrayList<>();
        }

        for (int i = 1; i < 10; i++) {
            list.add((long)i);
        }

        // 맨 앞자리 고정, 뒤에 올 수 있는 수 모두 구하기
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < i; j++) {
                String s = String.valueOf(i) + String.valueOf(j);
                Long num = Long.parseLong(s);
                nums[i].add(num);
                if (!list.contains(num)) {
                    list.add(num);
                }

                for (long prev : nums[j]){
                    s = String.valueOf(i) + String.valueOf(prev);
                    num = Long.parseLong(s);
                    nums[i].add(num);
                    if (!list.contains(num)) {
                        list.add(num);
                    }
                }
            }
        }

        Collections.sort(list);
        bw.write(String.valueOf(n > list.size() ? -1 : list.get(n - 1)));
        bw.flush();
    }
}
