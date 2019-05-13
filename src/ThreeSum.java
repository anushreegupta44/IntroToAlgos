import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{0, 0, 0, 0, 0};
        System.out.println(threeSum.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();

        if (nums.length < 3) {
            return new LinkedList<>();
        }
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            Map<Integer, Integer> map = new HashMap<>();
            int currentSum = sum - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(currentSum - nums[j])) {
                    List<Integer> sumArray = new ArrayList<>();
                    sumArray.add(nums[i]);
                    sumArray.add(currentSum - nums[j]);
                    sumArray.add(nums[j]);
                    if (!list.contains(sumArray)) {
                        list.add(sumArray);
                        map.put(nums[j], j);
                    }

                } else {
                    map.put(nums[j], j);
                }
            }
        }
        return list;
    }
}