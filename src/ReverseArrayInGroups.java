import java.util.Stack;

import static java.lang.Math.min;

public class ReverseArrayInGroups {
  private int[] array;

  public ReverseArrayInGroups(int[] array) {
    this.array = array;
  }

  public static void main(String[] args) {
    ReverseArrayInGroups reverseArrayInGroups = new ReverseArrayInGroups(new int[]{1, 2, 3, 4, 5});
    int group = 3;
    reverseArrayInGroups.reverseInGroups(group);
    System.out.print("\n");
    reverseArrayInGroups.reverseUsingStack(group);
  }

  private void reverseUsingStack(int group) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < array.length; i = i + group) {
      int j = i;
      int max = min(i + group, array.length);
      while (j < max) {
        stack.push(array[j]);
        j++;
      }
      while (!stack.empty()) {
        int k = j;
        for (int m = i; m < k; m++) {
          array[m] = stack.pop();
        }
      }
    }
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
    }
  }

  private void reverseInGroups(int group) {
    for (int i = 0; i < array.length; i = i + group) {
      int left = i;
      int right = min(i + group - 1, array.length - 1);
      while (left < right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        left++;
        right--;
      }
    }
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
    }

  }
}
