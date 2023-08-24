class Solution {
      public void rotate(int[] nums, int k) {
        // o n o n
        int[] arr = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
                  System.arraycopy(arr, 0, nums, 0, nums.length);

        System.out.println( Arrays.toString(arr));
}
}