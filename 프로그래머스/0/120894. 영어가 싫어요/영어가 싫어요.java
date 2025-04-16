class Solution {
    public long solution(String numbers) {
        StringBuilder sb = new StringBuilder();
        char[] nums = numbers.toCharArray();
        
        for (int i = 0 ; i < nums.length ; i +=3){
            if(nums[i] == 'z'){
                sb.append("0");
                i++;
            }
            else if(nums[i] == 'o') sb.append("1");
            else if(nums[i] == 't' && nums[i+1] == 'w') sb.append("2");
            else if(nums[i] == 't' && nums[i+1] == 'h') {
                sb.append("3");
                i += 2;
            }
            else if(nums[i] == 'f' && nums[i+1] == 'o') {
                sb.append("4");
                i += 1;
            }
            else if(nums[i] == 'f' && nums[i+1] == 'i') {
                sb.append("5");
                i += 1;
            }
            else if(nums[i] == 's' && nums[i+1] == 'i') sb.append("6");
            else if(nums[i] == 's' && nums[i+1] == 'e') {
                sb.append("7");
                i += 2;
            }
            else if(nums[i] == 'e') {
                sb.append("8");
                i += 2;
            }
            else if(nums[i] == 'n') {
                sb.append("9");
                i += 1;
            }
        }
        
        return Long.valueOf(sb.toString());
    }
}