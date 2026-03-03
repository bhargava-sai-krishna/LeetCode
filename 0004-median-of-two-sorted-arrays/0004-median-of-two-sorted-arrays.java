class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] combined = new int[m + n];

        int k = 0, i = 0, j = 0;

        while(i < n && j < m) {
            if(nums1[i] > nums2[j]) {
                combined[k] = nums2[j];
                j++;
            } else {
                combined[k] = nums1[i];
                i++;
            }
            k++;
        }

        while (i < n) {
            combined[k++] = nums1[i++];
        }

        while (j < m) {
            combined[k++] = nums2[j++];
        }

        int len = m + n;

        if(len % 2 == 0) {
            return (combined[len / 2] + combined[len / 2 - 1]) / 2.0;
        } else {
            return combined[(m + n) / 2];
        }
    }
}