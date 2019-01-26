package dz7;

public class testedClass3 {

    @BeforeSuite
    private void befor () {
        System.out.println("Начало");
    }

    @BeforeSuite
    private void befor1 () {
        System.out.println("Начало");
    }

    @AfterSuite
    private void after () {
        System.out.println("Конец");
    }

    @AfterSuite
    private void after1 () {
        System.out.println("Конец");
    }

    @Test (priority = 7)
    private void test1 () {
        System.out.println("7-й приоритет");
    }

    @Test
    private void test2 () {
        System.out.println("5-й приоритет");
    }

    @Test (priority = 1)
    private void test3 () {
        System.out.println("1-й приоритет");
    }

    @Test (priority = 4)
    private void test4 () {
        System.out.println("4-й приоритет");
    }

    @Test (priority = 9)
    private void test5 () {
        System.out.println("9-й приоритет");
    }

    @Test (priority = 10)
    private void test6 () {
        System.out.println("10-й приоритет");
    }

    @Test (priority = 8)
    private void test7 () {
        System.out.println("8-й приоритет");
    }

    @Test (priority = 2)
    private void test8 () {
        System.out.println("2-й приоритет");
    }

    @Test (priority = 3)
    private void test9 () {
        System.out.println("3-й приоритет");
    }

    @Test (priority = 6)
    private void test10 () {
        System.out.println("6-й приоритет");
    }
}
