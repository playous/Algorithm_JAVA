import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int len = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = 0;
        
        for (int i = 0 ; i < len ; i ++){
            if(A[idx] < B[i]) {
                answer++; 
                idx++;
            }
        }
        return answer;
    }
}