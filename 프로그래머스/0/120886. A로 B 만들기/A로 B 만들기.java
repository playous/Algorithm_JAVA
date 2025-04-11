class Solution {
    public int solution(String before, String after) {
        int[] alphabet = new int[26];
        char[] beforeArray = before.toCharArray();
        char[] afterArray = after.toCharArray();
        
        for (char ch : beforeArray){
            alphabet[ch-'a']++;
        }
        
        for (char ch : afterArray){
            alphabet[ch - 'a']--;
        }
        
        for (int n : alphabet){
            if (n != 0) return 0;
        }
        return 1;
    }
}