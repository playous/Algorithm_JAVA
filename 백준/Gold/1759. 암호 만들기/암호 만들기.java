import java.io.*;
import java.util.*;

public class Main {
    static int l, c;
    static char[] arr;
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        for (int i = 0; i <= c - l; i++) {
            calc(String.valueOf(arr[i]),i + 1, 1);
        }
        for (String s : answer) {
            bw.write(s + "\n");
        }
        bw.flush();
    }

    static void calc(String s, int idx , int count) {
        if (count == l){
            if (hasMom(s) && countBro(s)){
                answer.add(s);
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = idx; i < c; i++) {
            sb = sb.append(s).append(arr[i]);
            calc(sb.toString(),i + 1,count + 1);
            sb = new StringBuilder();
        }
    }
    static boolean hasMom(String s){
        if (s.contains("a") || s.contains("e") || s.contains("i") ||
                s.contains("o") || s.contains("u")){
            return true;
        }
        return false;
    }
    static boolean countBro(String s){
        int answer = s.length();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hasMom(String.valueOf(c))){
                answer --;
            }
        }
        if (answer < 2) return false;
        return true;
    }
}