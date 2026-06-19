import java.util.*;

class Solution {
    public class Node{
        int start;
        int end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    public int[] solution(String s) {
        
        HashSet<Integer> set = new HashSet<>();
        List<Node> list = new ArrayList<>();
        
        int sIdx = 0;
        int eIdx = 0;
        
        
        for (int i = 1; i < s.length() - 1 ; i ++){
            if (s.charAt(i) == '{'){
                sIdx = i + 1;
            }
            if (s.charAt(i) == '}'){
                eIdx = i;
                list.add(new Node(sIdx, eIdx));
            }
        }
        
        int size = list.size();
        
        int[] answer = new int[size];
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for (Node n : list){
            String[] arr = s.substring(n.start, n.end).split(",");
            
            int arrSize = arr.length;
            List<Integer> list1 = new ArrayList<>();
            
            for (int i = 0; i < arrSize; i ++){
                list1.add(Integer.parseInt(arr[i]));
            }
            
            map.put(arrSize, list1);
        }
        
        for (int i = 0 ; i < size ; i ++){
            List<Integer> list2 = map.get(i+1);
            
            for (int num : list2){
                if(!set.contains(num)){
                    set.add(num);
                    answer[i] = num;
                    break;
                }
            }
        }
        return answer;
    }
}