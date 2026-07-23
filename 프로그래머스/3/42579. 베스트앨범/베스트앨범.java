import java.util.*;

class Solution {
    class Node {
        String genre;
        int play;
        int sum;
        int id;
        Node(int id, int play, String genre){
            this.genre = genre;
            this.play = play;
            this.id = id;
        }
        
        public void add(int sum){
            this.sum = sum;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        
        HashMap<String, Integer> hmap = new HashMap<>();
        Node[] node = new Node[n];
        
        for (int i = 0 ; i < n ; i ++){
            String str = genres[i];
            int play = plays[i];
            node[i] = new Node(i, play, str);
            hmap.put(str, hmap.getOrDefault(str, 0) + play);
        }
        
        for (int i = 0 ; i < n ; i ++){
            int sum = hmap.get(node[i].genre);
            node[i].add(sum);
        }
        
        
        Arrays.sort(node, (a, b) -> {
            if (a.sum == b.sum){
                if(a.play == b.play){
                    return a.id - b.id;
                }
                return b.play - a.play;
            }
            return b.sum - a.sum;
        });
        
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> hmap2 = new HashMap<>();
        
        for (int i = 0 ; i < n ; i ++){
            String curGenre = node[i].genre;
            hmap2.put(curGenre, hmap2.getOrDefault(curGenre, 0) + 1);
            if (hmap2.get(curGenre) <= 2){
                list.add(node[i].id);
            }
        }
        
        int[] answer = new int[list.size()];
        
        int idx = 0;
        
        for (int id : list){
            answer[idx++] = id;
        }
        
        return answer;
    }
}