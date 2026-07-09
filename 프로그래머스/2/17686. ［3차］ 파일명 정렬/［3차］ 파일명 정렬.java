import java.util.*;

class Solution {
    class Node{
        int idx;
        String head;
        int number;
        
        public Node(int idx, String head, int number){
            this.idx = idx;
            this.head = head;
            this.number = number;
        }
    }
    
    List<Node> list;
    
    public String[] solution(String[] files) {
        int n = files.length;
        
        String[] answer = new String[n];
        
        this.list = new ArrayList<>();
        
        for (int i = 0; i < n ; i ++){
            calc(i, files[i]);
        }
        
        Collections.sort(list, (a, b) -> {
            if (a.head.compareTo(b.head) == 0){
                if (a.number == b.number){
                    return a.idx - b.idx;
                }
                else {
                    return a.number - b.number;
                }
            }
            else return a.head.compareTo(b.head);
        });
        
        int aIdx = 0;
        
        for (Node node : list){
            int id = node.idx;
            answer[aIdx++] = files[id];
        }
        return answer;
    }
    
    public void calc(int idx, String str){
        char[] arr = str.toCharArray();
        
        int idx1 = 0;
        int idx2 = 0;
        
        for (int i = 0; i < arr.length; i ++){
            if (arr[i] >= '0' && arr[i] <= '9'){
                idx1 = i;
                break;
            }
        }
        
        for (int i = idx1; i < arr.length; i ++){
            if (arr[i] < '0' || arr[i] > '9'){
                idx2 = i;
                break;
            }
        }
        
        if (idx2 == 0){
            idx2 = arr.length;
        }
        
        list.add(new Node(idx, str.substring(0,idx1).toLowerCase(), Integer.parseInt(str.substring(idx1, idx2))));
    }
    
}