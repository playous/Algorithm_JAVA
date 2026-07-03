import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        
        List<String>[] list1 = new List[10001];
        List<String>[] list2 = new List[10001];
        
        for (int i = 1; i <= 10000; i ++){
            list1[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }
        
        for (String s : words){
            StringBuilder sb = new StringBuilder(s);
            int len = s.length();
            
            list1[len].add(s);
            list2[len].add(sb.reverse().toString());
        }
        
        for (int i = 1; i <= 10000; i ++){
            Collections.sort(list1[i]);
            Collections.sort(list2[i]);
        }
        
        
        
        for (int i = 0 ; i < n ; i ++){
            int count = 0;
            String str = queries[i];
            int len = str.length();
            
            if (str.startsWith("?") && str.endsWith("?")){
                count = list1[len].size();
            }
            else if (str.endsWith("?")){
                String start = str.replace('?', 'a');
                String end = str.replace('?', 'z');
                count = upperBound(list1[len], end) - lowerBound(list1[len], start);
                
            }
            else if (str.startsWith("?")){
                String rStr = new StringBuilder(str).reverse().toString();
                String start = rStr.replace('?', 'a');
                String end = rStr.replace('?', 'z');
                count = upperBound(list2[len], end) - lowerBound(list2[len], start);
            }
            
            answer[i] = count;
        }
        
        return answer;
    }
    
    public int lowerBound(List<String> list, String target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid).compareTo(target) >= 0) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public int upperBound(List<String> list, String target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid).compareTo(target) > 0) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}