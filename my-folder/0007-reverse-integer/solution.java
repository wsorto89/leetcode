class Solution {
    public int reverse(int x) {
        char[] array = Integer.toString(x).toCharArray();
        int length = array.length - 1;
        
        if(x > 0) {
            for(int i = 0; i < (length+1)/2; i++) {
                char temp = array[i];
                array[i] = array[length - i];
                array[length - i] = temp;
            }
        } else {
            for(int i = 1; i <= (length+1)/2; i++) {
                char temp = array[i];
                array[i] = array[length - i + 1];
                array[length - i + 1] = temp;
            }
        }
        
        String result = new String(array);
        int answer = 0;
        try {
            answer = Integer.parseInt(result);
        } catch(Exception e) {
            answer = 0;
        }
        return answer;
    }
}
