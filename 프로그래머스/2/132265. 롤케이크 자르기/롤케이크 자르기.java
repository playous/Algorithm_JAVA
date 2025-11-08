import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        boolean[] visited = new boolean[10001];
        int[] left = new int[len];
        int[] right = new int[len];
        int count = 0;
        
        for (int i = 0 ; i < len; i ++){
            int cur = topping[i];
            if (!visited[cur]){
                visited[cur] = true;
                count++;
            }
            left[i] = count;
        }
        
        Arrays.fill(visited, false);
        count = 0;
        
        for (int i = len - 1 ; i >= 0; i --){
            int cur = topping[i];
            if (!visited[cur]){
                visited[cur] = true;
                count++;
            }
            right[i] = count;
        }
        
        for (int i = 0 ; i < len - 1; i ++){
            if (left[i] == right[i + 1]) answer++;
        }
        
        return answer;
    }
}