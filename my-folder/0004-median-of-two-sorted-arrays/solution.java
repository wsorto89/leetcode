class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1length = nums1.length;
        int n2length = nums2.length;
        ArrayList<Integer> combined = new ArrayList<Integer>();
        
        int i = 0;
        int j = 0;
        int combinedIndex = 0;
        int combinedSize = n1length + n2length;
        boolean isEven = combinedSize % 2 == 0 ? true : false;
        
        while(i < n1length && j < n2length) {
            if(combinedIndex == (combinedSize/2) + 1) {
                break;
            }
            if(nums1[i] <= nums2[j]) {
                combined.add(nums1[i]);
                i++;
            } else {
                combined.add(nums2[j]);
                j++;
            }
            combinedIndex++;
        }
        
        if(i >= n1length) {
            for(int x = j; x < n2length; x++) {
                if(combinedIndex == (combinedSize/2) + 1) {
                    break;
                }
                combined.add(nums2[x]);
                combinedIndex++;
            }
        } else {
            for(int x = i; x < n1length; x++) {
                if(combinedIndex == (combinedSize/2) + 1) {
                    break;
                }
                combined.add(nums1[x]);
                combinedIndex++;
            }
        }
        
        if(combined.size() == 1) {
            return combined.get(0);
        }
        if(!isEven) {
            return combined.get(combinedIndex - 1);
        } else {
            int x = combined.get(combinedIndex - 2);
            int y = combined.get(combinedIndex - 1);
            return (x + y)/2.0;
        }
    }
}
