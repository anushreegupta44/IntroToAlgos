public class ContainerWithMostWater {

  public static void main(String[] args) {
    ContainerWithMostWater c = new ContainerWithMostWater();
    System.out.println(c.maxArea(new int[]{1, 2, 1}));
  }

  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int globalMaxArea = 0;
    while (left != right) {
      if (height[left] < height[right]) {
        int maxArea = height[left] * (right - left);
        if (maxArea > globalMaxArea) {
          globalMaxArea = maxArea;
        }
        left++;
      } else if (height[right] < height[left]) {
        int maxArea = height[right] * (right - left);
        if (maxArea > globalMaxArea) {
          globalMaxArea = maxArea;
        }
        right--;
      } else if (height[left] == height[right] && right - left == 1) {
        int maxArea = height[right] * (right - left);
        if (maxArea > globalMaxArea) {
          globalMaxArea = maxArea;
        }
        left++;
      } else if (height[right] == height[left] && height[left + 1] > height[right - 1]) {
        int maxArea = height[right] * (right - left);
        if (maxArea > globalMaxArea) {
          globalMaxArea = maxArea;
        }
        left++;
      } else if (height[right] == height[left] && height[left + 1] < height[right - 1]) {
        int maxArea = height[right] * (right - left);
        if (maxArea > globalMaxArea) {
          globalMaxArea = maxArea;
        }
        right--;
      } else if (height[right] == height[left] && height[left + 1] == height[right - 1]) {
        int maxArea = height[right] * (right - left);
        if (maxArea > globalMaxArea) {
          globalMaxArea = maxArea;
        }
        right--;
      }
    }
    return globalMaxArea;
  }
}
