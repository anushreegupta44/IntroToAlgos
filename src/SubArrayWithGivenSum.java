import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrayWithGivenSum {
  private static void findSubarrayWithSum(List<Integer> list, Integer sum) {
    Integer currentSum = list.get(0);
    Integer start = 0;
    Integer i;
    Integer length = list.size();
    for (i = 1; i <= length; i++) {
      while (currentSum < sum && i < length) {
        currentSum += list.get(i);
        i++;
      }
      if (currentSum > sum) {
        currentSum -= list.get(start);
        start++;
      }
      if (currentSum.equals(sum)) {
        break;
      }
    }
    System.out.print("Start " + (start + 1) + "\n");
    System.out.print("end " + i + "\n");
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 8, 1));
    Integer sum = 12;
    findSubarrayWithSum(list, sum);
  }
}
