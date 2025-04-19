class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int index = 0;
        for (String s : quiz){
            String st[] = s.split(" ");
            int num = 0;
            int a = 1;
            for (String n : st){
                if (n.equals("=")) break;
                if (n.equals("-")) a = -1;
                else if (n.equals("+")) a = +1;
                else if (n.contains("-")){
                    num += ( a * -1 ) * Integer.parseInt(n.substring(1,n.length()));
                }
                else num += (a * Integer.parseInt(n));
            }
            String sum_s = s.substring(s.indexOf("=") + 2, s.length());
            System.out.println(sum_s);
            System.out.println("----------------");
            int sum = sum_s.contains("-") ? -1 * Integer.parseInt(sum_s.substring(1,sum_s.length())) : Integer.parseInt(sum_s);
            System.out.println(num);
            System.out.println(sum);
            
            answer[index++] = (num == sum) ? "O" :"X";
        }
        return answer;
    }
}