class Solution {
    public int removeDuplicates(int[] nums) {
        
            Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            if (map.getOrDefault(num, 0) + 1 <= 2) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

          int index = 0;
        int k = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int value = entry.getValue();
            for (int i = 0; i < value; i++) {
                nums[index++] = num;
                k++;
            }
        }
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
        System.out.println("map = " + map.size());
        return k;
    }
}