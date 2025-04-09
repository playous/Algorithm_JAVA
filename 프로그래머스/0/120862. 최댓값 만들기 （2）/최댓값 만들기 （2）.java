import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int answer = Integer.MIN_VALUE;
        
        if(numbers[0] * numbers[1] > answer){  // 음수 * 음수가 최대인 경우
          answer = numbers[0] * numbers[1];  
        } 
        if(numbers[numbers.length-2] * numbers[numbers.length-1] > answer){ // 양수 * 양수가 최대인 경우
            answer = numbers[numbers.length-2] * numbers[numbers.length-1];
        }
        return answer;
    }
}