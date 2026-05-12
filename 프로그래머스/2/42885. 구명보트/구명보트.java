import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right){
            
            int min = people[left];
            int max = people[right];
            
            int sum = min + max;
            
            if (sum <= limit){
                left++;
                right--;
            }
            else {
                right--;
            }
            answer++;
            
        }
        return answer;
    }
}