import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] alphabet = new long[26];
        boolean[] check = new boolean[10];
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            words[i] = s;
            int idx = s.length() - 1;
            for (int j = 0 ; j < s.length(); j++) {
                alphabet[s.charAt(j) - 'A'] += Math.pow(10, idx);
                idx--;
            }
        }

        List<Long> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > 0) {
                list.add(alphabet[i]);
            }
        }
        list.sort(Collections.reverseOrder());


        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > 0) {
                for (int j = 0 ; j < list.size(); j++) {
                    if (alphabet[i] == list.get(j) && !check[j]) {
                        check[j] = true;
                        map.put((char)('A' + i), 9 - j);
                        break;
                    }
                }
            }
        }

        long answer = 0;

        for (String word : words) {
            int idx = 1;
            for (int i = word.length() - 1; i >= 0; i--) {
                answer += (map.get(word.charAt(i)) * idx);
                idx *= 10;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}

