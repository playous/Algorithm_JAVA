import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        char[] arr = br.readLine().toCharArray();

        int mid = -1;
        if (n % 2 == 1) {
            mid = arr[n / 2] - 'a';
        }

        int[] alphabet = new int[26];
        
        for (char c : arr) {
            alphabet[c - 'a']++;
        }
        if (mid != -1){
            alphabet[mid]--;
        }
        
        boolean flag = true;
        for (int i : alphabet) {
            if (i % 2 != 0) {
                flag = false;
                break;
            }
        }

        if (flag) bw.write("Yes");
        else bw.write("No");
        
        bw.flush();
    }
}