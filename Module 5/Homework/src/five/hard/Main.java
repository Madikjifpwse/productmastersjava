package five.hard;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> numbers = new ArrayList<>();
    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      numbers.add(scanner.nextInt());
    }
    System.out.println("Список до удаления дубликатов: " + numbers);
    ArrayList<Integer> uniqueNumbers = removeDuplicates(numbers);
    System.out.println("Список после удаления дубликатов: " + uniqueNumbers);
  }
  public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
    Set<Integer> seen = new HashSet<>();
    ArrayList<Integer> result = new ArrayList<>();
    for (int num : list) {
      if (!seen.contains(num)) {
        seen.add(num);
        result.add(num);
      }
    }
    return result;
  }
}
