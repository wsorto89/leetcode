class Solution {
    public String intToRoman(int num) {
        String[] thousands = new String[]
        {"", "M", "MM", "MMM"};
        String[] hundreds = new String[]
        {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = new String[]
        {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = new String[]
        {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        String result = thousands[(num/1000)%10] + hundreds[(num/100)%10] + tens[(num/10)%10] + ones[num%10];
        
        return result;
    }
}
