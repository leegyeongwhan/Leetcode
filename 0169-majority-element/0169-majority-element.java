import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        int key = 0;
        System.out.println("max = " + map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if(max < value){
                max = Math.max(max, value);
                key = entry.getKey();
            }
        }
        System.out.println("max = " + max);
        System.out.println("key = " + key);
        //    System.out.println(" max.get().getKey() = " + max.get().getKey());
        return key;
    }
}