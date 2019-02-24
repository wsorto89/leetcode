class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int sum = 0;
        if(height.length < 3) {
            return sum;
        }
        for(int i = 0; i < height.length; i++) {
            //if we found an incline
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int prev = stack.pop();
                //can't do any calculations if it was right next to it
                if(!stack.isEmpty()) {
                    int distance = i - stack.peek() - 1;
                    int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[prev];
                    sum += distance * boundedHeight;
                }
            }
            stack.push(i);
        }
        
        return sum;
    }
}
