package dz7;

public class testedClass5 {

    @Test (priority = 9)
    private void test0 () {
        System.out.println("9-й приоритет 1-й по порядку");
    }

    @BeforeSuite
    private void befor () {
        System.out.println("Начало");
    }

    @Test (priority = 9)
    private void test01 () {
        System.out.println("9-й приоритет 2-й по порядку");
    }

    @AfterSuite
    private void after () {
        System.out.println("Конец");
    }

    @Test
    private void test1 () {
        System.out.println("5-й приоритет 1й по порядку");
    }

    @Test (priority = 9)
    private void test1_1 () {
        System.out.println("9-й приоритет 3-й по порядку");
    }

    @Test
    private void test2 () {
        System.out.println("5-й приоритет 2й по порядку");
    }

    @Test (priority = 8)
    private void test3 () {
        System.out.println("8-й приоритет 1-й по порядку");
    }

    @Test (priority = 4)
    private void test4 () {
        System.out.println("4-й приоритет");
    }

    @Test (priority = 9)
    private void test5 () {
        System.out.println("9-й приоритет 4-й по порядку");
    }

    @Test
    private void test6 () {
        System.out.println("5-й приоритет 3й по порядку");
    }

    @Test (priority = 9)
    private void test6_1 () {
        System.out.println("9-й приоритет 5-й по порядку");
    }

    @Test (priority = 8)
    private void test7 () {
        System.out.println("8-й приоритет 2-й по порядку");
    }

    @Test (priority = 2)
    private void test8 () {
        System.out.println("2-й приоритет");
    }

    @Test (priority = 3)
    private void test9 () {
        System.out.println("3-й приоритет");
    }

    @Test (priority = 9)
    private void test9_1 () {
        System.out.println("9-й приоритет 6-й по порядку");
    }

    @Test (priority = 6)
    private void test10 () {
        System.out.println("6-й приоритет");
    }

    @Test (priority = 8)
    private void test11 () {
        System.out.println("8-й приоритет 3-й по порядку");
    }

    @Test (priority = 8)
    private void test12 () {
        System.out.println("8-й приоритет 4-й по порядку");
    }

    @Test (priority = 9)
    private void test13 () {
        System.out.println("9-й приоритет 7-й по порядку");
    }

}
