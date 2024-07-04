class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[m + n];
        int i = 0, j = 0, k = 0;
        if (m==0&&n==0) 
        {
            return 0;
        }
        while (i < n && j < m) 
        {  
            if (nums1[i] <= nums2[j]) 
            {
                arr[k] = nums1[i];
                i = i + 1;
            } 
            else 
            {
                arr[k] = nums2[j];
                j = j + 1;
            }
            k = k + 1;
        }

        while (i < n) 
        {  
            arr[k] = nums1[i];
            i = i + 1;
            k = k + 1;
        }

        while (j < m) 
        { 
            arr[k] = nums2[j];
            j = j + 1;
            k = k + 1;
        }

        if ((m+n)%2!=0) 
        {
            return arr[(m+n)/2]; 
        } 
        else 
        {
            int temp=(m+n)/2;
            double a = arr[temp];
            double b = arr[temp - 1];
            return (a + b) / 2.0;
        }
    }
}