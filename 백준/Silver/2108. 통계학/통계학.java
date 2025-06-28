import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        int[] arr = new int[8001];
        double sum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            list.add(k);
            sum += k;
            k = k + 4000;
            arr[k]++;
        }

        for (int i : arr){
            if (i > max) max = i;
        }

        Collections.sort(list);

        int avg = (int) Math.round((double) sum / n);
        int mid = list.get(list.size() / 2);

        List<Integer> modes = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (arr[i] == max) {
                modes.add(i - 4000);
            }
        }

        int mode = modes.size() > 1 ? modes.get(1) : modes.get(0);
        int scope = list.get(list.size() - 1) - list.get(0);

        bw.write(String.valueOf(avg) + "\n"
                + String.valueOf(mid)+ "\n"
                + String.valueOf(mode) + "\n"
                + String.valueOf(scope));
        bw.flush();
    }
}