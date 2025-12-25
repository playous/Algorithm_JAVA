import java.util.*;

class Solution {
    static int len = 0;
    static int[] diff;
    static int[] time;
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        len = diffs.length;
        
        diff = new int[len];
        time = new int[len];
        
        for (int i = 0 ; i < len ; i++){
            diff[i] = diffs[i];
            time[i] = times[i];
        }
        
        int min = 1;
        int max = 100000;
        
        while (min <= max){
            int mid = (min + max) / 2;
            long res = calc(mid);
            if (res <= limit){
                answer = mid;
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }
        
        return answer;
    }
    
    public long calc (int level){
        long sum = time[0];
        for (int i = 1 ; i < len ; i ++){
            int cnt = level - diff[i];
            if (cnt >= 0) sum += time[i];
            else {
                sum += (time[i] + time[i -1]) * cnt * -1 + time[i];
            }
        }
        return sum;
    }
}