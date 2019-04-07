public class TrappingRainwater {
  int[] list;

  public TrappingRainwater(int[] list) {
    this.list = list;
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
    int hi = list.length - 1;
    while (lo <= hi) {
      if (list[lo] < list[hi]) {
        if (list[lo] > leftMax) {
          leftMax = list[lo];
        } else {
          water += leftMax - list[lo];
        }
        lo++;
      } else {
        if (list[hi] > rightMax) {
          rightMax = list[hi];
        } else {
          water += rightMax - list[hi];
        }
        hi--;
      }
    }
    return water;
  }

  private int maximumWaterHeld() {
    int[] leftMax = new int[list.length];
    int[] rightMax = new int[list.length];
    leftMax[0] = list[0];
    for (int i = 1; i < list.length; i++) {
      if (list[i] > leftMax[i - 1]) {
        leftMax[i] = list[i];
      } else {
        leftMax[i] = leftMax[i - 1];
      }
    }
    rightMax[list.length - 1] = list[list.length - 1];
    for (int i = list.length - 2; i >= 0; i--) {
      if (list[i] > rightMax[i + 1]) {
        rightMax[i] = list[i];
      } else {
        rightMax[i] = rightMax[i + 1];
      }
    }
    int maxWater = 0;
    for (int i = 0; i < list.length; i++) {
      if (leftMax[i] > rightMax[i]) {
        maxWater += rightMax[i] - list[i];
      } else {
        maxWater += leftMax[i] - list[i];
      }
    }
    return maxWater;
  }
}
