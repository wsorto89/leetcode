class Solution {
    boolean isPalindrome(String s) {
        int starting = 0;
        int ending = s.length() - 1;
        while(starting <= ending) {
            Character start = s.charAt(starting);
            Character end = s.charAt(ending);
            if(start != end) {
                return false;
            }
            starting++;
            ending--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int stringEnd = s.length();
        String result = "";
        for(int i = 0; i <= stringEnd; i++) {
            for(int j = i + 1; j <= stringEnd; j++) {
                String curString = s.substring(i, j);
                boolean isValid = isPalindrome(curString);
                if(isValid) {
                    if(curString.length() > result.length()) {
                        result = curString;
                    }
                }
            }
        }
        
        return result;
    }
}
