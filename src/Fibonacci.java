import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
  private int[] memo;

  public Fibonacci(int[] memo) {
    this.memo = memo;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));
    Integer num = Integer.valueOf(reader.readLine());

    System.out.print("Printing Fibonacci sequence\n");
    printFibonacciSeries(num);
    System.out.print("----------------------\n");
    System.out.print("Printing recursively\n");
    for (int i = 0; i < num; i++)
      System.out.println(printFibonacciSeriesRecursively(i));
    System.out.print("----------------------\n");
    System.out.print("Saving the calculated parts\n");
    int[] memo = new int[16];
    Fibonacci fibonacci = new Fibonacci(memo);
    System.out.print(fibonacci.findNthFibonacciNumber(15));
  }

  private static int printFibonacciSeriesRecursively(int n) {
    int sum = 0;
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    } else {
      sum = printFibonacciSeriesRecursively(n - 1) + printFibonacciSeriesRecursively(n - 2);

    }
    return sum;
  }

  private static void printFibonacciSeries(int n) {
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      if (i == 0 || i == 1) {
        array[i] = i;
        System.out.print(array[i] + "\n");
      } else {
        array[i] = array[i - 1] + array[i - 2];
        System.out.print(array[i] + "\n");
      }
    }
  }


  private Integer findNthFibonacciNumber(int n) {
    if (memo[n] != 0) {
      return memo[n];
    } else if (n == 1 || n == 0) {
      memo[n] = 1;
      return 1;
    } else {
      Integer fibonacci = findNthFibonacciNumber(n - 1) + findNthFibonacciNumber(n - 2);
      memo[n] = fibonacci;
      return fibonacci;
    }

  }
}
