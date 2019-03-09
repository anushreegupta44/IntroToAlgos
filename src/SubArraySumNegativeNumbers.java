import java.util.*;

public class SubArraySumNegativeNumbers {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(10, 2, -2, -20, 10));
    Integer sum = -10;
    findSubarrayWithSum(list, sum);

  }

  private static void findSubarrayWithSum(List<Integer> list, Integer sum) {
    Integer length = list.size();
    Integer start = 0;
    Integer end = 0;
    Integer currentSum = list.get(start);
    Map<Integer, Integer> cache = new HashMap<>();
    cache.put(currentSum, 0);
    for (int i = 1; i < length; i++) {
      if (currentSum > sum && cache.containsKey(currentSum - sum)) {
        start = cache.get(currentSum - sum) + 1;
        currentSum = sum;
      }
      if (currentSum.equals(sum)) {
        end = i - 1;
        break;
      }
      currentSum += list.get(i);
      cache.put(currentSum, i);
    }
    System.out.print(start + "\n");
    System.out.print(end + "\n");
  }
}
