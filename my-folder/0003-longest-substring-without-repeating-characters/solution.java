class Solution {
    public int lengthOfLongestSubstring(String s) {
        int inputLength = s.length();
        if(inputLength < 2) {
            return inputLength;
        }
        
        Map<Character, Integer> lastUniqueSubIndex = new HashMap<>();
        int result = 0;
        
        for(int i = 0, j = 0; j < inputLength; j++) {
            Character current = s.charAt(j);
            if(lastUniqueSubIndex.containsKey(current)) {
                i = Math.max(lastUniqueSubIndex.get(current), i);
            }
            result = Math.max(result, j - i + 1);
            lastUniqueSubIndex.put(current, j + 1);
        }
        
        return result;
    }
}
