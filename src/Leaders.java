public class Leaders {
  private int[] arr;

  public Leaders(int[] arr) {
    this.arr = arr;
  }

  public static void main(String[] args) {
    Leaders leaders = new Leaders(new int[]{16, 17, 4, 3, 5, 2});
    leaders.leadersInArray();
  }

  private void leadersInArray() {
    Integer lastLeader = arr[arr.length - 1];
    System.out.print(lastLeader + "\n");
    for (int i = arr.length - 1; i > 0; i--) {
      if (arr[i - 1] > lastLeader) {
        lastLeader = arr[i - 1];
        System.out.print(lastLeader + "\n");
      }
    }
  }
}
