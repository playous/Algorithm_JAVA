import java.util.*;

class Solution {   
    int len;
    int answer = 51;
    public int solution(String begin, String target, String[] words) {
        len = words.length;
        boolean[] visited = new boolean[len];
        dfs(begin, target, words, visited, 0);
        return answer == 51 ? 0 : answer;
    }
    
    void dfs(String begin , String target, String[] words, boolean[] visited, int count){
        if (begin.equals(target)) answer = Math.min(answer, count);
        for (int i = 0 ; i < len ; i++){
            if(canChange(words[i],begin) && !visited[i]){
                visited[i] = true;
                dfs(words[i], target, words, visited, count + 1);
                visited[i] = false;
            }
        }
    }
    
    boolean canChange(String s1, String s2){
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        return cnt == 1 ? true : false;
    }
}