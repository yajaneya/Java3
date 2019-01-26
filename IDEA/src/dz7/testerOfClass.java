package dz7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class testerOfClass {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        System.out.println("------------");
        System.out.println("Тест класса c одним BeforeSuite, одним AfterSuite и 10ю Test разных уровней");
        start(testedClass.class);
        System.out.println();

        System.out.println("------------");
        System.out.println("Тест класса с двумя AfterSuite");
        start(testedClass1.class); // класс с двумя AfterSuite
        System.out.println();

        System.out.println("------------");
        System.out.println("Тест класса с двумя BeforeSuite");
        start(testedClass2.class); // класс с двумя BeforeSuite
        System.out.println();

        System.out.println("------------");
        System.out.println("Тест класса с двумя AfterSuite и с двумя BeforeSuite");
        start(testedClass3.class); // класс с двумя AfterSuite и с двумя BeforeSuite
        System.out.println();

        System.out.println("------------");
        System.out.println("Тест класса без AfterSuite и BeforeSuite");
        start(testedClass4.class); // класс без AfterSuite и BeforeSuite
        System.out.println();

        System.out.println("------------");
        System.out.println("Тест класса с Test, имеющими одинаковый приоритет");
        start(testedClass5.class); // класс без AfterSuite и BeforeSuite

    }
    private static void start(Class<?> tClass) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Method[] methods =  tClass.getDeclaredMethods();
        // тест на количество начальных и конечных блоков
        if (!testSuites(methods)) {
            System.out.println("Не корректное количество начальных и(или) конечных аннотаций в " + tClass.toString());
            return;
        }

        Constructor constructor = tClass.getConstructor();
        Object instance = constructor.newInstance();


        //выполнение начального блока
        Method met = anMethod(methods, BeforeSuite.class);
        if (met != null) {
            met.setAccessible(true);
            met.invoke(instance);
        }


        //выполнение блоков Test
        ArrayList<Method> tests []= new ArrayList [10];

        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                Test test = m.getAnnotation(Test.class);
                int priority = test.priority();
                if (tests [priority - 1] == null) {
                    tests [priority-1] = new ArrayList<>();
                }
                tests [priority-1].add(m);
            }
        }

        for (int i=0; i< tests.length; i++) {
            if (tests[i] != null) {
                for (int j = 0; j < tests[i].size(); j++) {
                    if (tests[i].get(j) != null) {
                        met = tests[i].get(j);
                        met.setAccessible(true);
                        met.invoke(instance);
                    }
                }
            }
        }


        //выполнение конечного блока
        met = anMethod(methods, AfterSuite.class);
        if (met != null) {
            met.setAccessible(true);
            met.invoke(instance);
        }
    }

    // проверка на количество BeforeSuite и AfterSuite
    private static boolean testSuites (Method[] methods) {
        boolean isBS = false, isAS = false;
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (isBS) {
                    return false;
                } else {
                    isBS = true;
                }
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (isAS) {
                    return false;
                } else {
                    isAS = true;
                }
            }
        }
        return true;
    }

    // поиск метода по аннотации
    private static Method anMethod (Method[] methods, Class annot) {
        for (Method m: methods) {
            if (m.isAnnotationPresent(annot)) {
                return m;
            }
        }
        return null;
    }

}
