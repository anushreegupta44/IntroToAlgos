import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KadaneAlgo {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(-2, -3, 4, -1, -2, 1, 5, -3));
    System.out.print(findMaximumContinuousSum(list) + "\n");
    System.out.print(kadanesAlgorithm(list));
  }

  private static Integer findMaximumContinuousSum(List<Integer> list) {
    Integer maxSumGlobal = 0;
    Integer maxSumLocal = 0;
    for (int i = 0; i < list.size(); i++) {
      if (maxSumLocal + list.get(i) < 0) {
        maxSumLocal = 0;
        continue;
      }
      maxSumLocal += list.get(i);
      if (maxSumLocal > maxSumGlobal) {
        maxSumGlobal = maxSumLocal;
      }
    }
    return maxSumGlobal;
  }

  private static Integer kadanesAlgorithm(List<Integer> list) {
    Integer maxSumTillHere = list.get(0);
    Integer maxSumGlobal = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      maxSumTillHere = Math.max(maxSumTillHere + list.get(i), list.get(i));
      if (maxSumTillHere > maxSumGlobal) {
        maxSumGlobal = maxSumTillHere;
      }
    }
    return maxSumGlobal;
  }
}
