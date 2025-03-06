package six.easy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 2, 9, 1, 7, 3, 2);
        Numberprocess process = new Numberprocess(numbers);

        System.out.println("Минимум: " + process.Min());
        System.out.println("Максимум: " + process.Max());
        System.out.println("Сортировка по возрастанию: " + process.sortAsc());
        System.out.println("Сортировка по убыванию: " + process.sortDesc());
        System.out.println("Содержит " + process.contains(9));
        System.out.println("Фильтр >3: " + process.GreaterThan(3));
        System.out.println("Сумма всех чисел: " + process.Sum());
    }
}
class Numberprocess {
    private final List<Integer> numbers;

    public Numberprocess(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }
    public int Min() {
        return Collections.min(numbers);
    }
    public int Max() {
        return Collections.max(numbers);
    }
    public List<Integer> sortAsc() {
        List<Integer> sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        return sortedList;
    }
    public List<Integer> sortDesc() {
        List<Integer> sortedList = new ArrayList<>(numbers);
        sortedList.sort(Collections.reverseOrder());
        return sortedList;
    }
    public boolean contains(int number) {
        return numbers.contains(number);
    }
    public List<Integer> GreaterThan(int value) {
        List<Integer> filteredList = new ArrayList<>();
        for (int num : numbers) {
            if (num > value) {
                filteredList.add(num);
            }
        }
        return filteredList;
    }
    public int Sum() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
