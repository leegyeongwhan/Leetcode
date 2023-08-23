class Solution {
    public int removeDuplicates(int[] nums) {
           Set<Integer> set = new LinkedHashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int index = 0;
        for (Integer elm : set) {
            nums[index] = elm;
            index++;
        }
        System.out.println("set = " + set);
        return set.size();
    }
    
}