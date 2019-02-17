class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList(rowIndex);
        if (rowIndex < 0)
        {
            return list;
        }
        
        helper(rowIndex, list);
        return list;
    }
    
    private void helper(int numRows, List<Integer> list) {
        if (numRows == 0)
        {
            list.add(1);
        }
        else {
            helper(numRows - 1, list);
            for(int i = numRows - 1; i >= 1; i--)
            {
                list.set(i, list.get(i) + list.get(i - 1));
            }
            list.add(1);
        }
    }
}
