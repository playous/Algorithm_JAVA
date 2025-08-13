import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        boolean[] alphabet = new boolean[26];
        boolean[] check = new boolean[n];
        List<Integer>[] list = new List[n];
        String[] arr = new String[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            list[i] = new ArrayList<>();
            list[i].add(0);
        }


        String[] arr2 = new String[n]; // 모두 소문자로 변환
        for (int i = 0; i < n; i++) {
            arr2[i] = arr[i].toLowerCase();
            for (int j = 1 ; j < arr[i].length() ; j++) {
                if(arr[i].charAt(j) == ' '){
                    list[i].add(j + 1);
                }
            }
            max = Math.max(max, list[i].size());
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int num : list[i]) {
                char c = arr2[i].charAt(num);
                if (!alphabet[c - 'a']) {
                    alphabet[c - 'a'] = true;
                    check[i] = true;
                    found = true;
                    map.put(i, num);
                    break;
                }
            }
            if (!found) {
                for (int j = 1 ; j < arr2[i].length() ; j++) {
                    char c = arr2[i].charAt(j);
                    if (c == ' ') continue;
                    if (!alphabet[c - 'a']) {
                        alphabet[c - 'a'] = true;
                        check[i] = true;
                        map.put(i, j);
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(!check[i]) sb.append(arr[i] + "\n");
            else{
                int idx = map.get(i);
                for (int j = 0 ; j < arr[i].length(); j++) {
                    if (j == idx) {
                        sb.append("[" + arr[i].charAt(j) + "]");
                    }
                    else sb.append(arr[i].charAt(j));
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

}