import java.util.Arrays;


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
            int num1Index = m - 1;
        int num2Index = nums2.length - 1;
        int pos = n + m - 1;

        while (num2Index >= 0) {
            if (num1Index >= 0 && nums1[num1Index] > nums2[num2Index]) {
                nums1[pos] = nums1[num1Index];
                num1Index--;
            } else {
                nums1[pos] = nums2[num2Index];
                num2Index--;
            }
            pos--;
        }
        }
}