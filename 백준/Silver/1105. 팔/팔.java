import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String L = st.nextToken();
        String R = st.nextToken();

        int answer = 0;
        boolean flag = false;
        for (int i = 0; i < L.length(); i++) {
            int a = L.charAt(i) - '0';
            int b = R.charAt(i) - '0';
            if(a == 8 && b == 8) {
                if (!flag) {
                    answer ++;
                    flag = false;
                }
            }
            else if (a < b) flag = true;

        }

        if (L.length() < R.length()) {
            answer = 0;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }

}