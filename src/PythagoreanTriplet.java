import java.util.Arrays;

public class PythagoreanTriplet {
  public static void main(String[] args) {
    int[] array = new int[]{3, 1, 4, 6, 5};
    System.out.print(doesAPythagoreanTripletExist(array));
  }

  private static boolean doesAPythagoreanTripletExist(int[] array) {
    Arrays.sort(array);
    for (int i = 0; i < array.length; i++) {
      array[i] = array[i] * array[i];
    }
    for (int i = 2; i < array.length; i++) {
      int low = 0;
      int high = i - 1;
      while (low != high) {
        if (array[low] + array[high] == array[i]) {
          return true;
        } else if (array[low] + array[high] < array[i]) {
          low++;
        } else high--;
      }
    }
    return false;
  }
}
