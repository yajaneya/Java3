package dz5;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private ArrayList<String> rezults;
    private String endRace;

    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(String endRace, Stage... stages) {
        this.endRace = endRace;
        rezults = new ArrayList<>();
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public void addRezalt (String name, String rez) {
        if (rez.contains(endRace))
            rezults.add(name);
    }

    public void setEndRace(String endRace) {
        this.endRace = endRace;
    }

    public void rezults () {
        System.out.println("********************************");
        System.out.println("*** РЕЗУЛЬТАТЫ  СОРЕВНОВАНИЯ ***");
        System.out.println("********************************");
        System.out.println("   1 место - " + rezults.get(0));
        System.out.println("   2 место - " + rezults.get(1));
        System.out.println("   3 место - " + rezults.get(2));
        System.out.println("********************************");
    }
}