import java.io.*;
import java.util.*;

public class Main {
    static int answer =0;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[26];
        HashSet<Character>[] wordSet = new HashSet[n];
        for (int i = 0; i < n; i++) {
            wordSet[i] = new HashSet<>();
            String s = br.readLine();
            for (int j = 4; j < s.length() - 4; j++) {
                wordSet[i].add(s.charAt(j));
            }
        }
        for (HashSet<Character> set : wordSet) {
            set.remove('a');
            set.remove('n');
            set.remove('t');
            set.remove('i');
            set.remove('c');
        }

        if(k < 5){
            bw.write("0");
            bw.flush();
            return;
        }

        visited[0] = visited[2] = visited[8] = visited[13] = visited[19] = true; // a,c,i,n,t
        k -= 5;

        boolean[] usedChars = new boolean[26];

        int cant = 0;
        for (int i = 0; i < n; i++) {
            if(wordSet[i].size() > k){
                wordSet[i].clear();
                cant++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (char c : wordSet[i]) {
                usedChars[c - 'a'] = true;
            }
        }

        backtrack(n,k,0,visited,wordSet, usedChars);
        bw.write(answer - cant +"");
        bw.flush();
    }

    static void backtrack(int n, int k, int start,  boolean[] visited, HashSet<Character>[] words, boolean[] usedChars) {
        if(flag) return;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (words[i].size() == 0) {
                cnt++;
            }
        }
        answer = Math.max(cnt, answer);

        if (answer == n) flag = true;

        if(k== 0) return;

        for (int i = start + 1; i < 26; i++) {
            if(flag) return;
            if (!visited[i] && usedChars[i]) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if(words[j].contains((char) ('a' + i))){
                        list.add(j);
                        words[j].remove((char) ('a' + i));
                    }
                }
                if(list.isEmpty()){
                    continue;
                }
                visited[i] = true;
                backtrack(n,k - 1,i, visited,words, usedChars);
                for (int idx : list) {
                    words[idx].add((char) ('a' + i));
                }
                visited[i] = false;
            }
        }
    }
}