import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
class Solution {
    public int majorityElement(int[] nums) {
              Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Optional<Map.Entry<Integer, Integer>> max = map.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        System.out.println(" max.get().getKey() = " +  max.get().getKey());
        return max.get().getKey();
    }
}