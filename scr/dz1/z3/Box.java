package dz1.z3;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> box;

    public Box () {
        this.box = new ArrayList();
    }

    public void add (T fruit) {
        box.add(fruit);
    }

    public float getWeight() {
        float boxWeight = 0;
        for (T fruit: box) {
            boxWeight += fruit.weight;
        }
        return boxWeight;
    }


    public boolean compare (Box<?> boxC) {
        return this.getWeight() == boxC.getWeight();
    }

    public void pour (Box<T> boxP) {
        while (box.size()>0) {
            boxP.add(box.get(0));
            box.remove(0);
        }
    }



    @Override
    public String toString() {
        return "Box{" +
                "box=" + box +
                '}';
    }
}
