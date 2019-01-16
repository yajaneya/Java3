package dz6;

import org.junit.*;

import java.sql.SQLException;

public class Z3Test {
    private Z3 z;

    @Before
    public void startTest() throws SQLException, ClassNotFoundException {
        z = new Z3();
    }

    @After
    public void endTest() throws SQLException {
        z.endSessions();
        z = null;
    }

    @Test
    public void testAdd() throws SQLException {
        int key = z.add("Иванов", 5);
        Assert.assertEquals(true, z.find(key,"Иванов", 5));
        z.delete(key);
    }

    @Test
    public void testUpd() throws SQLException {
        int key = z.add("Иванов", 5);
        z.update(key, "Петров", 4);
        Assert.assertEquals(true, z.find(key,"Петров", 4));
        z.delete(key);
    }

    @Test
    public void testRead() throws SQLException {
        int key = z.add("Иванов", 5);
        Assert.assertEquals(key+ " Иванов 5", z.read(key));
        z.delete(key);
    }
}
