import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        int todayYear = Integer.parseInt(today.substring(0,4));
        int todayMonth = Integer.parseInt(today.substring(5,7));
        int todayDay = Integer.parseInt(today.substring(8,10));
        
        int[] alphabet = new int[(int)('z' - 'a') + 1];
        for(String s : terms){
            String[] str = s.split(" ");
            alphabet[(str[0].charAt(0) -'A')] = Integer.parseInt(str[1]);
        }
        int index = 1;
        
        for (String s : privacies){
            String[] str = s.split(" ");
            String[] date = str[0].split("\\."); // .은 특수문자이므로 이스케이프 처리 필요!!!!
            int plusMonth = alphabet[str[1].charAt(0) -'A'];
            int pYear = Integer.parseInt(date[0]);
            int pMonth = Integer.parseInt(date[1]);
            int pDay = Integer.parseInt(date[2]);
            
            pMonth += plusMonth;
            if(pMonth > 12){
                if (pMonth % 12 == 0){
                    pYear += pMonth/12 -1;
                    pMonth = 12;
                }
                else{
                    pYear += pMonth/12;
                    pMonth %= 12;
                }
            }
            if(pYear < todayYear) list.add(index);
            else if (pYear == todayYear) {
                if (pMonth < todayMonth) list.add(index);
                else if (pMonth == todayMonth){
                    if (pDay <= todayDay) list.add(index);
                }
            }
            index++;
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0 ; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}