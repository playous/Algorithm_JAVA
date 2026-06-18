import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(enroll[i], i);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String cur = seller[i];
            int money = amount[i] * 100;
            
            while (!cur.equals("-") && money > 0) {
                int idx = map.get(cur);
                
                int nextMoney = money / 10;
                int curMoney = money - nextMoney;
                
                answer[idx] += curMoney;
                
                cur = referral[idx];
                money = nextMoney;
            }
        }
        
        return answer;
    }
}