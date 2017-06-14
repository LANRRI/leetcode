package leetcode;

/**
 * Created by ruidli on 2017/6/14.
 */
public class MedianOfTwoArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length+nums2.length;
        return findKth(total/2+1,nums1,nums2,0,0);
    }

    public int findKth(int k ,int [] nums1 , int [] nums2 , int start1 ,int start2){
        if (start1 >= nums1.length){
            return nums1[start2 + k -1];
        }
        if (start2 >= nums2.length){
            return nums1[start1 + k -1];
        }
        if (k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        int m1 = start1 + k/2 -1;
        int m2 = start2 +k/2 -1;
        int value1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
        int value2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;
        if (value1 < value2){
            return findKth(k-k/2,nums1,nums2,m1+1,start2);
        }
        return findKth(k-k/2,nums1,nums2,start1,m2+1);
    }
}
