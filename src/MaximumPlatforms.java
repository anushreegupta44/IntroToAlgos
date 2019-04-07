public class MaximumPlatforms {
  private int[] arrivals;
  private int[] departures;

  private static Integer max = 1;

  public MaximumPlatforms(int[] arrivals, int[] departures) {
    this.arrivals = arrivals;
    this.departures = departures;
  }

  public static void main(String[] args) {
    MaximumPlatforms maximumPlatforms = new MaximumPlatforms(new int[]{900, 950, 1500, 910, 1120, 1900},
        new int[]{940, 1100, 1800, 1200, 1130, 2000});
    maximumPlatforms.findMaximumPlatforms();
    System.out.print(max);
  }

  private void findMaximumPlatforms() {
    int length = arrivals.length;
    for (int i = 0; i < length; i++) {
      Integer maximumPlatforms = 1;
      for (int j = i + 1; j < length; j++) {
        if (departures[i] > arrivals[j] && arrivals[i] < arrivals[j]) {
          maximumPlatforms++;
        }
      }
      if (maximumPlatforms > max) {
        max = maximumPlatforms;
      }
    }
  }
}
