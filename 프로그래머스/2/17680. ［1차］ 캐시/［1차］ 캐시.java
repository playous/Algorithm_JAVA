import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int len = cities.length;
        
        if (cacheSize == 0) return len * 5;
        
        List<String> list = new LinkedList<>();
        
        for (int i = 0 ; i < len ; i ++){
            String city = cities[i].toUpperCase();
            if (list.contains(city)){
                answer += 1;
                list.remove(city);
                list.add(city);
            }
            else {
                if (list.size() == cacheSize){
                    list.remove(0);
                }
                list.add(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}