class Solution {
    public int solution(String[] spell, String[] dic) {
        int spell_len = spell.length;
        
        for(String st : dic){
            int check = spell_len;
            int dic_len = st.length();
            if(dic_len == spell_len){
                for(String s : spell){
                    int cnt = st.contains(s) ? 1 : 0;
                    check -= cnt;
                } 
            }
            if (check == 0) return 1;
        }
        return 2;
    }
}