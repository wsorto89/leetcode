class Solution {
    public int myAtoi(String str) {
        StringBuilder numStr = new StringBuilder("");
        boolean sequenceStarted = false;
        int result = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == ' ') {
                if (sequenceStarted) {
                    break;
                } else {
                    continue;
                }
            } else if (numStr.length() == 0 && (cur == '+' || cur == '-')) {
                numStr.append(cur);
            } else if (Character.isDigit(cur)) {
                numStr.append(cur);
            } else {
                break;
            }
            sequenceStarted = true;
        }
        
        try {
            if (numStr.length() == 0) {
                result = 0;
            } else if (numStr.length() == 1 && (numStr.charAt(0) == '+' || numStr.charAt(0) == '-')) {
                result = 0;
            } else {
                result = Integer.parseInt(numStr.toString());
            }
        } catch (Exception exception) {
            if (numStr.charAt(0) == '-') {
                result = Integer.MIN_VALUE;
            } else {
                result = Integer.MAX_VALUE;
            }
        } finally {
            return result;
        }
    }
}
