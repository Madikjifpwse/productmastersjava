package five.medium;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<DayOfWeek> weekDays = new ArrayList<>();
    for (DayOfWeek day : DayOfWeek.values()) {
      weekDays.add(day);
    }
    System.out.println("Список дней недели: " + weekDays);
    for (DayOfWeek day : weekDays) {
      System.out.println(day + " - выходной? " + isWeekend(day));
    }
  }
  public static boolean isWeekend(DayOfWeek day) {
    return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
  }
}
