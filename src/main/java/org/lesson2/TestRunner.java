package org.lesson2;

import org.lesson2.PriorityMethod;
import org.lesson2.annotation.AfterSuite;
import org.lesson2.annotation.AfterTest;
import org.lesson2.annotation.BeforeSuite;
import org.lesson2.annotation.BeforeTest;
import org.lesson2.annotation.CsvSource;
import org.lesson2.annotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {
    public static void runTests(Class clazz) {
        try {
            Class.forName(clazz.getName());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getException().getMessage());
            return;
        }
        var methods = clazz.getDeclaredMethods();
        if (methods.length == 0) {
            System.out.println(clazz.getSimpleName() + " : Нет размеченных нужными аннотациями методов в классе: "
                    + clazz.getName());
            return;
        }
        List<PriorityMethod> test = new ArrayList<>();
        List<Method> beforeTest = new ArrayList<>();
        List<Method> afterTest = new ArrayList<>();
        Method beforeSuite = null;
        Method afterSuite = null;
        for (var m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                if (Modifier.isStatic(m.getModifiers())) {
                    throw new RuntimeException(clazz.getSimpleName() + " : Аннотация @Test не может быть установлена на " +
                            "статический метод");
                } else {
                    var priority = m.getAnnotation(Test.class).priority();
                    if (priority > 0 && priority < 11) {
                        test.add(new PriorityMethod(m, priority));
                    } else {
                        throw new RuntimeException(clazz.getSimpleName() + " : Значение параметра priority аннотации @Test лежит " +
                                "за пределами диапазонов от 1 до 10");
                    }
                }
            }
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (Modifier.isStatic(m.getModifiers())) {
                    if (beforeSuite != null) {
                        throw new RuntimeException(clazz.getSimpleName() + " : Количество методов с аннотацией @BeforeSuite" +
                                " превышает допустимое значения");
                    }
                    beforeSuite = m;
                } else {
                    throw new RuntimeException(clazz.getSimpleName() + " : Аннотация @BeforeSuite установлена на не " +
                            "статический метод");
                }
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (Modifier.isStatic(m.getModifiers())) {
                    if (afterSuite != null) {
                        throw new RuntimeException(clazz.getSimpleName() + " : Количество методов с аннотацией @AfterSuite " +
                                "превышает допустимое значения");
                    }
                    afterSuite = m;
                } else {
                   throw new RuntimeException(clazz.getSimpleName() + " : Аннотация @AfterSuite установлена на не " +
                            "статический метод");
                }
            }
            if (m.isAnnotationPresent(BeforeTest.class)) {
                beforeTest.add(m);
            }
            if (m.isAnnotationPresent(AfterTest.class)) {
                afterTest.add(m);
            }
            if (m.isAnnotationPresent(CsvSource.class) && !(m.isAnnotationPresent(Test.class))) {
                throw new RuntimeException(clazz.getSimpleName() + " : Аннотация @CsvSource может быть применена, " +
                        "только вместе с аннотацией @Test");
            }
        }
        execMethods(clazz, beforeSuite, afterSuite, test, beforeTest, afterTest);
    }

    private static void execMethods(Class clazz, Method beforeSuite, Method afterSuite,
                                    List<PriorityMethod> test, List<Method> beforeTest,
                                    List<Method> afterTest) {
        try {
            var constructor = clazz.getConstructor();
            test.sort(Comparator.comparing(PriorityMethod::getPriority).reversed());
            try {
                var objectClazz = constructor.newInstance();
                if (beforeSuite != null) {
                    beforeSuite.setAccessible(true); // по хорошему нужна еще проверка, чтобы вернуть обратно уровень доступнсти
                    beforeSuite.invoke(objectClazz);
                }
                for (var m : test) {
                    var method = m.getMethod();
                    method.setAccessible(true); // по хорошему нужна еще проверка, чтобы вернуть обратно уровень доступнсти
                    for (var bm : beforeTest) {
                        bm.setAccessible(true);
                        bm.invoke(objectClazz);
                    }
                    invokeMethod(method, objectClazz);
                    for (var am : afterTest) {
                        am.setAccessible(true);
                        am.invoke(objectClazz);
                    }
                }
                if (afterSuite != null) {
                    afterSuite.setAccessible(true); // по хорошему нужна еще проверка, чтобы вернуть обратно уровень доступнсти
                    afterSuite.invoke(objectClazz);
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                System.out.println(clazz.getSimpleName() + " : " + e.getMessage());
            }
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void invokeMethod(Method method, Object object) throws InvocationTargetException, IllegalAccessException {
        if (method.isAnnotationPresent(CsvSource.class)) {
            var source = method.getAnnotation(CsvSource.class).source();
            var args = source.replace(" ", "").split(",");
            var parameters = method.getParameters();
            Object[] arguments = new Object[args.length];

            if (args.length != parameters.length) {
                throw new RuntimeException(object.getClass() + " : Неверное количество аргументов в аннотации @CsvSource");
            }

            for (int i = 0; i < args.length; i++) {
                Object value = null;
                if (isNumeric(args[i])) {
                    value = Integer.parseInt(args[i]);
                } else if (isBoolean(args[i])) {
                    value = Boolean.parseBoolean(args[i]);
                } else {
                    value = parameters[i].getType().cast(args[i]);
                }
                arguments[i] = value;
            }

            method.invoke(object, arguments);
        } else {
            method.invoke(object);
        }

    }

    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }

    private static boolean isBoolean(String str) {
        return "true".equals(str) || "false".equals(str);
    }
}
