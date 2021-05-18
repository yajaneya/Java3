package dz1.z1;

public class Cats {
    String name;
    boolean male; // false - кот, true - кошка

    public Cats(String name, boolean male) {
        this.name = name;
        this.male = male;
    }

    @Override
    public String toString() {
        return "{" +
                "Имя " + ((male) ? "кошки":"кота") + " : " + name + '\'' +
                '}';
    }
}
