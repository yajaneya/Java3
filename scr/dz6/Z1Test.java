package dz6;


import org.junit.*;

public class Z1Test {
    private Z1 z;

    @Before
    public void startTest() {
        z = new Z1();
    }

    @After
    public void endTest() {
        z = null;
    }

    @Test
    public void testArrAfterFour1() {
        int [] vhod = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int [] vyhod = {1, 7};
        Assert.assertArrayEquals(vyhod, z.arrAfterFour(vhod));
    }

    @Test(expected = RuntimeException.class)
    public void testArrAfterFour2() {
        int [] vhod = {1, 2, 2, 3, 1, 7};
        int [] vyhod = null;
        Assert.assertArrayEquals(vyhod, z.arrAfterFour(vhod));
    }

    @Test
    public void testArrAfterFour3() {
        int [] vhod = {4, 2, 2, 6, 2, 3, 9, 1, 7};
        int [] vyhod = {2, 2, 6, 2, 3, 9, 1, 7};
        Assert.assertArrayEquals(vyhod, z.arrAfterFour(vhod));
    }

    @Test
    public void testArrAfterFour4() {
        int [] vhod = {4, 2, 2, 4, 2, 3, 9, 1, 4};
        int [] vyhod = {};
        Assert.assertArrayEquals(vyhod, z.arrAfterFour(vhod));
    }
}
