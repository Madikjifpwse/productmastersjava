import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Printer<String> printer = new StringPrinter();
        printer.print(text);
    }
}

interface Printer<T> {
    void print(T value);
}

class StringPrinter implements Printer<String> {
    @Override
    public void print(String value) {
        System.out.println(value);
    }
}
