import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> ranks = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            ranks.put(players[i], i);
        }
        
        for (String called : callings) {
            int currentRank = ranks.get(called);
            String player = players[currentRank - 1];
            
            players[currentRank - 1] = called;
            players[currentRank] = player;
            
            ranks.put(called, currentRank - 1);
            ranks.put(player, currentRank);
        }
        
        return players;
    }
}