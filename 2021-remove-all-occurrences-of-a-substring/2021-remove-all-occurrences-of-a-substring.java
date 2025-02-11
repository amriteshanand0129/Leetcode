class Solution {
    int stackSize = 0;
    public boolean checkAndRemove(Stack<Character> stack, String part, int index) {
        if(index < 0) return true;

        char ch = stack.pop();
        stackSize--;
        if(ch == part.charAt(index) && checkAndRemove(stack, part, index-1)) 
            return true;
        
        stack.push(ch);
        stackSize++;
        return false;
    }
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            stack.push(s.charAt(i));
            stackSize++;
            if(stackSize >= part.length()) 
                checkAndRemove(stack, part, part.length()-1);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) 
            sb.append(stack.pop());
        
        return sb.reverse().toString();
    }
}