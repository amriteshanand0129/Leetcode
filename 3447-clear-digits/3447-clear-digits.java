class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                stack.pop();
            } else {    
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) 
            sb.append(stack.pop());
        
        return sb.reverse().toString();
    }
}