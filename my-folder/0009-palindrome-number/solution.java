class Solution {
    public boolean isPalindrome(int x) {
        String string = Integer.toString(x);
        int length = string.length() - 1;
        for(int i = 0; i <= length/2; i++) {
            if(string.charAt(i) != string.charAt(length - i)) {
                return false;
            }
        }
        
        return true;
    }
}
