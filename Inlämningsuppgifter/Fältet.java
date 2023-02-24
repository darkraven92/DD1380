import java.util.*;

public class Falt {
  static int[][] grid;
  static int n, m;

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      n = sc.nextInt();
      m = sc.nextInt();

      // Läs in fältet
      grid = new int[n][m];
      for (int i = 0; i < n; i++) {
          String line = sc.next();
          for (int j = 0; j < m; j++) {
             if (line.charAt(j) == 'x') {
                  grid[i][j] = -1; // Staket
              } else {
                  grid[i][j] = 0; // Mark
              }
          }
      }

      // Räkna ut antal rutor som kan nås från vänster respektive höger kant
      int[] left = new int[n];
      int[] right = new int[n];
      for (int i = 0; i < n; i++) {
          left[i] = dfs(i, 0, 1);
          right[i] = dfs(i, m-1, 2);
      }

      // Räkna ut antal rutor som kan nås från både vänster och höger kant
      int both = 0;
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              if (grid[i][j] == 3) {
                  both++;
              }
          }
      }

      // Skriv ut resultatet
      System.out.println(Arrays.stream(left).sum() + " " + Arrays.stream(right).sum() + " " + both);
  }

  // Djupet-först-sökning för att räkna ut antal rutor som kan nås från en viss kant
  static int dfs(int i, int j, int mark) {
      if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == -1 || (grid[i][j] & mark) > 0) {
          // Ute ur fältet eller staket, eller redan besökt från den här kanten
          return 0;
      }

      grid[i][j] |= mark; // Markera som besökt från den här kanten

      int count = 1;
      count += dfs(i-1, j, mark);
      count += dfs(i+1, j, mark);
      count += dfs(i, j-1, mark);
      count += dfs(i, j+1, mark);

      return count;
  }
