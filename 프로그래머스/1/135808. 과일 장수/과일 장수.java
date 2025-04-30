import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : score){
            if(i <= k) list.add(i);
        }
        list.sort((a,b) -> b-a);
        
        int len = list.size();
        
        for (int i = 0 ; i < len; i += m){
            int sum = 0;
            if (i + m - 1 < len){
                answer += m * list.get(i + m -1);
            }
        }
        return answer;
    }
}