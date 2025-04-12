class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        char[] ch = s.toCharArray();
        int[] alphabet = new int['z' - 'a' + 1];
        
        for (char c : ch){
            alphabet[c-'a']++;
        }
        for (int i = 0 ; i < alphabet.length; i++){
            if(alphabet[i] == 1) sb.append((char)('a' +i));
        }
        return sb.toString();
    }
}