package six.medium;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    File file = new File("medium/words.txt");
    Map<String, Integer> wordCount = new HashMap<>();
    Set<String> uniqueWords = new HashSet<>();
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNext()) {
        String word = scanner.next().toLowerCase().replaceAll("[^a-zа-я0-9]", "");
        if (!word.isEmpty()) {
          uniqueWords.add(word);
          wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("Файл не найден.");
      return;
    }
    System.out.println("Уникальные слова: " + uniqueWords);
    System.out.println("Частота слов:");
    for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
