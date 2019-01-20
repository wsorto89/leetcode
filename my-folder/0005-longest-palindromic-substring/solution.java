class Solution {
    void printArray(boolean[][] array) {
        for(int i = 0; i < array[0].length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                System.out.print("[" + array[i][j] + "]");
                if(j == array[0].length - 1) {
                    System.out.println();
                }
            }
        }
    }
    
    String updateLongest(String s, String currentLongest, int i, int j) {
        String result = currentLongest;
        String curPalindrome = s.substring(i, j + 1);
        if(result.length() < curPalindrome.length()) {
            result = curPalindrome;
        }
        return result;
    }
    
    public String longestPalindrome(String s) {
        String result = "";
        int stringEnd = s.length();
        boolean[][] isPalindrome = new boolean[stringEnd][stringEnd];
        
        if(stringEnd < 2) {
            return s;
        }
        
        //base cases:
        //string of length 1 is always a palindrome
        for(int i = 0; i < stringEnd; i++) {
            isPalindrome[i][i] = true;
            if(i == 0) {
                result = updateLongest(s, result, i, i);
            }
        }
        
        //string of length 2 where both characters match is palindrome
        for(int i = 0; i < stringEnd - 1; i++) {
            boolean isValid = s.charAt(i) == s.charAt(i + 1);
            isPalindrome[i][i + 1] = isValid;
            isPalindrome[i + 1][i] = isValid;
            if(isValid) {
                result = updateLongest(s, result, i, i + 1);
            }
        }
        
        for(int i = stringEnd; i >= 0; i--) {
            for(int j = i + 1; j < stringEnd; j++) {
                boolean isValid = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                isPalindrome[i][j] = isValid;
                if(isValid) {
                    String curPalindrome = s.substring(i, j + 1);
                    if(result.length() < curPalindrome.length()) {
                        result = curPalindrome;
                    }
                }
            }
        }
        
        //printArray(isPalindrome);
        
        return result;
    }
}
