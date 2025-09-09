import java.io.*;
import java.util.*;

public class Main {
    static class Word{
        String word;
        int rank;
        public Word(String word, int rank) {
            this.word = word;
            this.rank = rank;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Word> list = new ArrayList<>();
        String[] arr = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            list.add(new Word(s, i));
            arr[i] = s;
        }

        list.sort((a,b) -> (a.word.compareTo(b.word)));

        HashSet<String> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            char[] c1 = list.get(i).word.toCharArray();
            char[] c2 = list.get(i + 1).word.toCharArray();
            if(list.get(i).word.equals(list.get(i + 1).word)) {
                continue;
            }
            int idx = 0;
            for (int j = 0; j < c1.length; j++) {
                if (c1[j] != c2[j]) {
                    break;
                }
                idx++;
            }
            if (idx > max) {
                max = idx;
                set.clear();
                set.add(list.get(i).word);
                set.add(list.get(i + 1).word);
            }
            else if (idx == max) {
                set.add(list.get(i).word);
                set.add(list.get(i + 1).word);
            }
        }
        int idx = 0;
        String s = "0";
        for (int i = 1; i <= n; i++) {
            if (set.contains(arr[i])) {
                if (idx == 0){
                    bw.write(arr[i] + "\n");
                    s = arr[i];
                    idx ++;
                }
                else{
                    if(s.equals(arr[i])) {
                        continue;
                    }
                    int j = 0;
                    for (; j < max; j++) {
                        if (s.charAt(j) != arr[i].charAt(j)){
                            break;
                        }
                    }
                    if (j == max) {
                        bw.write(arr[i] + " ");
                        break;
                    }
                }
            }
        }

        bw.flush();
    }
}