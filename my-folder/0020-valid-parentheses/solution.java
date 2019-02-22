class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) {
            return true;
        }
        
        Deque<Character> stack = new ArrayDeque<Character>();
        for(Character c : s.toCharArray())
        {
            if(stack.isEmpty())
            {
                if(isOpeningChar(c))
                {
                    stack.push(c);
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(isOpeningChar(c))
                {
                    stack.push(c);
                }
                else
                {
                    Character end = stack.peek();
                    if(isCorrespondingClosingChar(end, c))
                    {
                        stack.pop();
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isOpeningChar(Character c) {
        if(c == '(' || c == '{' || c == '[')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private boolean isCorrespondingClosingChar(Character open, Character close) {
        if((open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']'))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
