public class Main {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(100);
        System.out.println("Содержимое: " + intBox.getItem());
        intBox.showType();
        intBox.setItem(200);
        System.out.println("Новое содержимое: " + intBox.getItem());
        Box<String> strBox = new Box<>("Hello world!");
        System.out.println("Содержимое: " + strBox.getItem());
        strBox.showType();
        MyData myData = new MyData(1, "Описание данных");
        Box<MyData> myDataBox = new Box<>(myData);
        System.out.println("Содержимое: " + myDataBox.getItem());
        myDataBox.showType();
    }
}
