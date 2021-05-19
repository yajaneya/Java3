package dz6;

public class Z1 {
    private int [] arr;


    public int [] arrAfterFour(int[] ar) {
        int [] arRes;
        int i;
        boolean find = false;
        for (i = ar.length-1; i >= 0; i--) {
            if (ar[i] == 4) {
                find = true;
                break;
            }
        }

        if (find) {
            arRes = new int[ar.length-1-i];
            for (int j = 0; j<arRes.length; j++) {
                arRes[j] = ar[j+i+1];
            }
            return arRes;
        } else {
            throw new RuntimeException();
        }
    }
}
