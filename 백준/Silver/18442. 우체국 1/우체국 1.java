import java.io.*;
import java.util.*;

public class Main {
    static int v, p;
    static long l;
    static long[] arr;
    static boolean[] visited, answerArr;
    static long min =  Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        l = Long.parseLong(st.nextToken());

        arr = new long[v];
        visited = new boolean[v];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < v ; i ++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        backTrack(0, 0);

        bw.write(min + "\n");
        for (int i = 0 ; i < v ; i ++){
            if (answerArr[i]) bw.write(arr[i] + " ");
        }
        bw.flush();
    }
    static void backTrack(int count, int start){
        if (count == p){
            long s = calc();
            if (s < min){
                min = s;
                answerArr = visited.clone();
            }
            return;
        }
        for (int i = start; i < v; i ++){
            if (!visited[i]){
                visited[i] = true;
                backTrack(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }
    static long calc(){
        long[] minArr = new long[v];
        long sum = 0;
        Arrays.fill(minArr, Long.MAX_VALUE);
        for (int i = 0; i < v ; i ++){
            if (visited[i]){
                for (int j = 0 ; j < v ; j ++){
                    minArr[j] = Math.min(minArr[j], Math.min(Math.abs(arr[i] - arr[j]),l - Math.abs(arr[i] - arr[j])));
                }
            }
        }
        for (int i = 0; i < v; i ++){
            sum += minArr[i];
        }
        return sum;
    }
}