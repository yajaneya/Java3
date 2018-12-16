package dz1.z1;

public class TestChangePlaceMass {
    public static void main(String[] args) {
        String [] s = {"речь", "печь", "мечь"};
        Integer [] i = {5, 2, 7, 7, 3, 2};
        Boolean [] b = {true, false, false, true, false};
        Cats [] c = {new Cats("Мурзик", false), new Cats("Мурка", true), new Cats("Барсик", false)};
        ChangePlaceMass <String> S = new ChangePlaceMass<>(s);
        ChangePlaceMass <Integer> I = new ChangePlaceMass<>(i);
        ChangePlaceMass <Boolean> B = new ChangePlaceMass<>(b);
        ChangePlaceMass <Cats> C = new ChangePlaceMass<>(c);


        System.out.println("--- Проверка на символьном массиве ---");
        System.out.println("Начальный массив: " + S.toString());
        S.changePlaceElements(0, 2);
        System.out.println(S.toString());
        System.out.println();

        System.out.println("--- Проверка на числовом массиве ---");
        System.out.println("Начальный массив: " + I.toString());
        I.changePlaceElements(0, 2);
        System.out.println(I.toString());
        System.out.println();

        System.out.println("--- Проверка на булевом массиве ---");
        System.out.println("Начальный массив: " + B.toString());
        B.changePlaceElements(0, 2);
        System.out.println(B.toString());
        System.out.println();

        System.out.println("--- Проверка на котовом массиве ---");
        System.out.println("Начальный массив: " + C.toString());
        C.changePlaceElements(0, 2);
        System.out.println(C.toString());
        System.out.println();
    }

}
