import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int n, int[] numlist) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int a : numlist){
            if(a % n == 0) answer.add(a);
        }
        return answer;
    }
}