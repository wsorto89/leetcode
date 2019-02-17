class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> retVal = new ArrayList(numRows);
        if (numRows < 1)
        {
            return retVal;
        }
        generateHelper(numRows, retVal);
        
        return retVal;
    }
    
    private void generateHelper(int numRows, List<List<Integer>> list) {
        List rowList = new ArrayList<Integer>(numRows);
        if (numRows == 1)
        {
            rowList.add(1);
            list.add(rowList);
        }
        else {
            generateHelper(numRows - 1, list);
            for(int i = 0; i < numRows; i++)
            {
                if(i == 0 || i == (numRows - 1))
                {
                    rowList.add(1);
                }
                else
                {
                    List<Integer> prevRow = list.get(numRows - 2);
                    rowList.add(prevRow.get(i - 1) + prevRow.get(i));
                }
            }
            list.add(rowList);
        }
    }
}
