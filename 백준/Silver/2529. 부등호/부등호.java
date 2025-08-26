import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static long max = 0;
    static long min = Long.MAX_VALUE;
    static int k;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new char[k];
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        for (int i = 0; i <= 9; i++) {
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            backTrack(i, set, 0);
        }
        if (String.valueOf(max).length() < k + 1) {
            bw.write('0');
        }
        bw.write(String.valueOf(max) + "\n");
        if (String.valueOf(min).length() < k + 1) {
            bw.write('0');
        }
        bw.write(String.valueOf(min) + "\n");
        bw.flush();
    }

    static void backTrack(long n, HashSet<Integer> set, int idx){
        if(idx == k){
            max = Math.max(max, n);
            min = Math.min(min, n);
            return;
        }
        long last = n % 10;
        for (int i = 0; i <= 9; i++) {
            if(!set.contains(i)){
                if(arr[idx] == '<'){
                    if(last < i){
                        set.add(i);
                        backTrack(n * 10 + i, set, idx + 1);
                        set.remove(i);
                    }
                }
                if (arr[idx] == '>'){
                    if(last > i){
                        set.add(i);
                        backTrack(n * 10 + i, set, idx + 1);
                        set.remove(i);
                    }
                }
            }
        }
    }
}