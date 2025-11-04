import java.io.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        boolean flag = false;
        while (true){
            int next = -1;
            if (storey == 0) break;
            if (storey == 10) {
                answer++;
                break;
            }
            int cur = storey % 10;
            storey /= 10;
            if (storey != 0){
                next = storey % 10;
            }
            if (flag){
                cur += 1;
                flag = false;
            }
            System.out.println(cur);
            if (cur == 0) continue;
            if (cur == 10) {
                flag = true;
            }
            if (cur == 5){
                System.out.println(next);
                if (next < 5) flag = false;
                else flag = true;
                answer += 5;
            }
            else if (cur < 5) answer += cur;
            else if (cur > 5) {
                answer += (10 - cur);
                flag = true;
            }
            if (flag && storey == 0){
                storey = 10;
            }
        }
    
        return answer;
    }
}