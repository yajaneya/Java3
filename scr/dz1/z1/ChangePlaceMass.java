package dz1.z1;

import java.util.Arrays;

public class ChangePlaceMass<T> {
    private T [] mass;

    public ChangePlaceMass(T[] mass) {
        this.mass = mass;
    }

    public T [] changePlaceElements(int one, int two) {
        if (one>mass.length-1 | two>mass.length-1) {
            System.out.println("*** Номер элемента за пределом массива ***");
            return mass;
        }
        System.out.println("Меняем элементы " + (one+1) + " и " + (two+1) + ":");
        T temp = mass[one];
        mass[one] = mass[two];
        mass[two] = temp;
        return mass;
    }

    @Override
    public String toString() {
        return Arrays.toString(mass);
    }
}
