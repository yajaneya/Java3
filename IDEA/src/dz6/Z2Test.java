package dz6;

import org.junit.*;

public class Z2Test {
    private Z2 z;

    @Before
    public void startTest() {
        z = new Z2();
    }

    @After
    public void endTest() {
        z = null;
    }

    @Test
    public void testAnMass1() {
        int [] vhod = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        boolean vyhod = true;
        Assert.assertEquals(vyhod, z.anMass(vhod));
    }

    @Test
    public void testAnMass2() {
        int [] vhod = {1, 2, 7, 12, 2, 3, 74, 1, 7};
        boolean vyhod = true;
        Assert.assertEquals(vyhod, z.anMass(vhod));
    }

    @Test
    public void testAnMass3() {
        int [] vhod = {11, 2, 42, 34, 2, 3, 44, 14, 7};
        boolean vyhod = false;
        Assert.assertEquals(vyhod, z.anMass(vhod));
    }

    @Test
    public void testAnMass4() {
        int [] vhod = {13, 2, 4, 4, 2, 3, 4, 41, 7};
        boolean vyhod = true;
        Assert.assertEquals(vyhod, z.anMass(vhod));
    }


}
