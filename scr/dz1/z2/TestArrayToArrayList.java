package dz1.z2;

import java.util.ArrayList;

public class TestArrayToArrayList {
    public static void main(String[] args) {
        String [] s = {"речь", "печь", "мечь"};
        Integer [] i = {5, 2, 7, 7, 3, 2};
        Boolean [] b = {true, false, false, true, false};
        Cats [] c = {new Cats("Мурзик", false), new Cats("Мурка", true), new Cats("Барсик", false)};
        ArrayToArrayList<String> S = new ArrayToArrayList<>(s);
        ArrayToArrayList<Integer> I = new ArrayToArrayList<>(i);
        ArrayToArrayList<Boolean> B = new ArrayToArrayList<>(b);
        ArrayToArrayList<Cats> C = new ArrayToArrayList<>(c);


        System.out.println("--- Проверка на символьном массиве ---");
        System.out.println("Массив: " + S.toString());
        ArrayList<String> sAL = S.arrayToAL();
        System.out.println("ArrayList: " + sAL.toString());
        System.out.println();

        System.out.println("--- Проверка на числовом массиве ---");
        System.out.println("Начальный массив: " + I.toString());
        ArrayList<Integer> iAL = I.arrayToAL();
        System.out.println("ArrayList: " + iAL.toString());
        System.out.println();

        System.out.println("--- Проверка на булевом массиве ---");
        System.out.println("Начальный массив: " + B.toString());
        ArrayList<Boolean> bAL = B.arrayToAL();
        System.out.println("ArrayList: " + bAL.toString());
        System.out.println();

        System.out.println("--- Проверка на котовом массиве ---");
        System.out.println("Начальный массив: " + C.toString());
        ArrayList<Cats> cAL = C.arrayToAL();
        System.out.println("ArrayList: " + cAL.toString());
        System.out.println();
    }

}
