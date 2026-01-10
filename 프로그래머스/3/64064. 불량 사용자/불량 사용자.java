import java.util.*;
import java.io.*;

class Solution {
    static int len1, len2, answer;
    static String[] user;
    static String[] ban;
    static HashSet<String> memo;
    
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        
        len1 = user_id.length;
        len2 = banned_id.length;
        
        memo = new HashSet<>();
        
        boolean[] visited = new boolean[len2];
        boolean[] visited1 = new boolean[len1];
        
        user = new String[len1];
        ban = new String[len2];
        
        for (int i = 0 ; i < len1; i++){
            user[i] = user_id[i];
        }
        for (int i = 0 ; i < len2; i++){
            ban[i] = banned_id[i];
        }
        
        calc(0, visited, visited1, 0);
        
        return answer;
    }
    
    static void calc(int idx, boolean[] visited, boolean[] visited1, int count){
        if (count == len2) {
            String s = make(visited1);
            if (!memo.contains(s)){
                memo.add(s);
                answer ++;
            }
            return;
        }
        for (int i = idx; i < len1; i++){
            for (int j = 0 ; j < len2; j ++){
                if (visited[j]) continue;
                if (check(i,j)){
                    visited[j] = true;
                    visited1[i] = true;
                    calc(i + 1, visited, visited1, count + 1);
                    visited[j] = false;
                    visited1[i] = false;
                }
            }
        }
    }
    
    static boolean check(int i, int j){
        int n1 = user[i].length();
        int n2 = ban[j].length();
        
        if (n1 != n2) return false;
        
        for (int k = 0; k < n1 ; k++){
            if (ban[j].charAt(k) == '*') continue;
            if (ban[j].charAt(k) != user[i].charAt(k)) return false;
        }
        
        return true;
    }
    
    static String make(boolean[] visited){
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < len1 ; i++){
            if(visited[i]) sb.append(i).append(" ");
        }
        return sb.toString();
    }
}