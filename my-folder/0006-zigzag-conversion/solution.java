class Solution {
    public String convert(String s, int numRows) {
        String result = "";
        
        String[][] zigzag = new String[numRows][s.length()];
        int currentRow = 0;
        int currentColumn = 0;
        boolean down = true;
        
        if (numRows == 1) {
            return s;
        }
        
        for(int i = 0; i < s.length(); i++) {
            if (down) {
                zigzag[currentRow++][currentColumn] = String.valueOf(s.charAt(i));
            } else {
                zigzag[currentRow--][currentColumn++] = String.valueOf(s.charAt(i));
            }
            if (currentRow == 0) {
                down = true;
            } else if (currentRow == (numRows - 1)) {
                down = false;
            }
        }
        
        //printZigzag(zigzag);
        result = convertArrayToString(zigzag);
        
        return result;
    }
    
    String convertArrayToString(String[][] array) {
        String result = "";
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                if (array[i][j] != null) {
                    result = result.concat(array[i][j]);
                }
            }
        }
        
        return result;
    }
    
    void printZigzag(String[][] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                if (array[i][j] != null) {
                    System.out.print("[" + array[i][j] + "]");
                } else {
                    System.out.print("[  ]");
                }
            }
            System.out.println();
        }
    }
}
