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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] A = new char[n][m];
        char[][] B = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                A[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                B[i][j] = s.charAt(j);
            }
        }
        int answer = 0;

        if (n < 3 || m < 3) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(A[i][j] == B[i][j]) {
                        count++;
                    }
                }
            }
            if (count == n * m ) answer = 0;
            else answer = - 1;
        }

        else {
            for (int i = 0; i < n - 2; i++) {
                for (int j = 0; j < m - 2; j++) {
                    if (A[i][j] != B[i][j]) {
                        for (int k = i; k < i + 3; k++) {
                            for (int l = j; l < j + 3; l++) {
                                A[k][l] = A[k][l] == '0' ? '1' : '0';
                            }
                        }
                        answer++;
                        if (check(A, B)) {
                            break;
                        }
                    }
                }
            }
        }

        if (!check(A, B)) answer = -1;
        bw.write(String.valueOf(answer));
        bw.flush();
    }
    static boolean check(char[][] A, char[][] B) {
        boolean flag = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if(A[i][j] != B[i][j]){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}