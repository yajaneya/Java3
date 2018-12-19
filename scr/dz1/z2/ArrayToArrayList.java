package dz1.z2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayToArrayList<T> {
    private T [] mass;

    public ArrayToArrayList(T[] mass) {
        this.mass = mass;
    }

    public ArrayList <T> arrayToAL() {
        ArrayList<T> massAL = new ArrayList<>();
        Collections.addAll(massAL, mass);
        return massAL;
    }

    @Override
    public String toString() {
        return Arrays.toString(mass);
    }
}
