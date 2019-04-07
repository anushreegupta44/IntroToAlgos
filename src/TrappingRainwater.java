public class TrappingRainwater {
  private int[] array;

  public TrappingRainwater(int[] array) {
    this.array = array;
  }

  public static void main(String[] args) {
    TrappingRainwater trappingRainwater = new TrappingRainwater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    System.out.println(trappingRainwater.maximumWaterHeld());
    System.out.print(trappingRainwater.trap());

  }

  //optimised space complexity, no extra arrays
  private int trap() {
    int water = 0;
    int leftMax = 0;
    int rightMax = 0;
    int lo = 0;
    int hi = array.length - 1;
    while (lo <= hi) {
      if (array[lo] < array[hi]) {
        if (array[lo] > leftMax) {
          leftMax = array[lo];
        } else {
          water += leftMax - array[lo];
        }
        lo++;
      } else {
        if (array[hi] > rightMax) {
          rightMax = array[hi];
        } else {
          water += rightMax - array[hi];
        }
        hi--;
      }
    }
    return water;
  }

  private int maximumWaterHeld() {
    int[] leftMax = new int[array.length];
    int[] rightMax = new int[array.length];
    leftMax[0] = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] > leftMax[i - 1]) {
        leftMax[i] = array[i];
      } else {
        leftMax[i] = leftMax[i - 1];
      }
    }
    rightMax[array.length - 1] = array[array.length - 1];
    for (int i = array.length - 2; i >= 0; i--) {
      if (array[i] > rightMax[i + 1]) {
        rightMax[i] = array[i];
      } else {
        rightMax[i] = rightMax[i + 1];
      }
    }
    int maxWater = 0;
    for (int i = 0; i < array.length; i++) {
      if (leftMax[i] > rightMax[i]) {
        maxWater += rightMax[i] - array[i];
      } else {
        maxWater += leftMax[i] - array[i];
      }
    }
    return maxWater;
  }
}
