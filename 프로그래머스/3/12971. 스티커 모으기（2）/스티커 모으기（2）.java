import java.util.*;
import java.io.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;
        /*
        0 -> 미선택
        1 -> 선택
        */
        int[][] dp0 = new int[2][len];  // 0번 인덱스 시작
        int[][] dp1 = new int[2][len];  // 1번 인덱스 시작
        
        if (len == 1) return sticker[0];
        
        dp0[0][0] = 0;
        dp0[1][0] = sticker[0];
        
        for (int i = 1; i < len ; i ++){
            dp0[0][i] = Math.max(dp0[0][i-1] , dp0[1][i-1]);
            dp0[1][i] = dp0[0][i-1] + sticker[i];
        }
        int a1 = Math.max(dp0[0][len - 1], dp0[1][len - 1] - sticker[0]);

        dp1[0][1] = 0;
        dp1[1][1] = sticker[1];
        
        for (int i = 1; i < len ; i ++){
            dp1[0][i] = Math.max(dp1[0][i-1] , dp1[1][i-1]);
            dp1[1][i] = dp1[0][i-1] + sticker[i];
        }
        int a2 = Math.max(dp1[0][len - 1], dp1[1][len - 1]);

        answer = Math.max(a1, a2);
        return answer;
    }
}