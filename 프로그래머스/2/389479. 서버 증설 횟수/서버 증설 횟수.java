import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        for (int i = 0 ; i < 24 ; i ++){
            int plus = 0;
            if(players[i] >= m){
                plus = players[i] / m;
            }
            for (int j = i ; j < i + k ; j ++){
                if(j == 24) break;
                players[j] -= (plus * m);
            }
            answer += plus;
        }
        
       
        return answer;
    }
}