import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int[] check = new int[cards.length];
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < cards.length ; i ++){
            if(check[i] != 0) continue;
            int cnt = 1;
            check[i]++;
            int j = cards[i] -1;
            while(i != j){
                cnt++;
                check[j]++;
                j = cards[j] - 1;
            }
            list.add(cnt);
        }
        
        list.sort((a,b) -> b- a);
        return list.size() == 1 ? 0 : list.get(0) * list.get(1);
    }
}