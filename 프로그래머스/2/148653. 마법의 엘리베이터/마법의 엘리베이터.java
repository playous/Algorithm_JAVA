import java.io.*;

class Solution {  
    /*
     2^9 내려가거나 or 올라가거나
    */
    int[] arr;
    int len, answer;
    
    public int solution(int storey) {
        answer = Integer.MAX_VALUE;
            
        char[] ch = String.valueOf(storey).toCharArray();
        
        len = ch.length;
        arr = new int[len];
        
        int idx = len - 1;
        
        for (char c : ch){
            arr[idx--] = c - '0';
        }
    
        calc(arr[0], 1, 0);
        calc(10 - arr[0], 1, 1);
        
        return answer;
    }
    
    public void calc (int sum, int cnt, int plus){
        if (cnt == len){
            if (plus == 1) sum += 1;
            answer = Math.min(answer, sum);
            return;
        }
        
        if(plus == 1){
            if (arr[cnt] == 9) calc(sum, cnt + 1, 1);
            else {
                // 내려가기
                calc(sum + arr[cnt] + 1, cnt + 1, 0);
                // 올라가기
                calc(sum + 10 - (arr[cnt] + 1), cnt + 1, 1);
            }
        }
        else {
            // 내려가기
            calc(sum + arr[cnt], cnt + 1, 0);
            // 올라가기
            calc(sum + 10 - arr[cnt], cnt + 1, 1);
        }
    }
}