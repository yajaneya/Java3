package dz1.z3;

public class TestBoxFruits {
    public static void main(String[] args) {

        Box <Apple> boxApple = new Box<>();
        int numApple = 3;
        for (int i=0; i<numApple; i++) boxApple.add(new Apple());
        System.out.println(boxApple.toString());
        System.out.println(boxApple.getWeight());
        System.out.println("================");
        System.out.println();

        Box <Orange> boxOrange = new Box<>();
        int numOrange = 5;
        for (int i=0; i<numOrange; i++) boxOrange.add(new Orange());
        System.out.println(boxOrange.toString());
        System.out.println(boxOrange.getWeight());
        System.out.println("================");
        System.out.println();

        Box <Orange> boxOrange2 = new Box<>();
        int numOrange2 = 2;
        for (int i=0; i<numOrange2; i++) boxOrange2.add(new Orange());
        System.out.println(boxOrange2.toString());
        System.out.println(boxOrange2.getWeight());
        System.out.println("================");
        System.out.println();

        System.out.println("Сравнение масс Коробки яблок и Коробки апельсинов: " + boxApple.compare(boxOrange));
        System.out.println("Сравнение масс Коробки яблок и 2й Коробки апельсинов: " + boxOrange2.compare(boxApple));
        System.out.println();

        System.out.println("Пересыпем из Коробки Апельсинов во 2ю Коробку апельсинов");
        boxOrange.pour(boxOrange2);
        System.out.println("Коробка апельсинов: " + boxOrange.toString());
        System.out.println("2я Коробка апельсинов: " + boxOrange2.toString());
    }
}
