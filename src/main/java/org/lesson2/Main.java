package org.lesson2;

import org.lesson2.examples.Lesson2Example1;
import org.lesson2.examples.Lesson2Example10;
import org.lesson2.examples.Lesson2Example11;
import org.lesson2.examples.Lesson2Example2;
import org.lesson2.examples.Lesson2Example3;
import org.lesson2.examples.Lesson2Example4;
import org.lesson2.examples.Lesson2Example5;
import org.lesson2.examples.Lesson2Example6;
import org.lesson2.examples.Lesson2Example7;
import org.lesson2.examples.Lesson2Example8;
import org.lesson2.examples.Lesson2Example9;

public class Main {
    public static void main(String[] args) {
        TestRunner.runTests(Lesson2Example1.class); // Нет размеченных методов
        System.out.println("\n");
        TestRunner.runTests(Lesson2Example2.class); // @AfterSuite на не статическом методе
        System.out.println("\n");
        TestRunner.runTests(Lesson2Example3.class); // @BeforeSuite на не статическом методе
        System.out.println("\n");
        TestRunner.runTests(Lesson2Example4.class); // priority в тесте за пределами диапазона
        System.out.println("\n");
        TestRunner.runTests(Lesson2Example5.class); // количество методов с @BeforeSuite больше 1
        System.out.println("\n");
        TestRunner.runTests(Lesson2Example6.class); // количество методов с @AfterSuite больше 1
        System.out.println("\n");
        TestRunner.runTests(Lesson2Example7.class); // @Test на статическом методе
        System.out.println("\n");
        TestRunner.runTests(Lesson2Example8.class); // Валидный пример с полным выводом
        System.out.println("\n");
        TestRunner.runTests(Lesson2Example9.class); // Валидный пример, но без @AfterSuite
        System.out.println("\n");
        TestRunner.runTests(Lesson2Example10.class); // Валидный пример, но без @BeforeSuite
        System.out.println("\n");
        TestRunner.runTests(Lesson2Example11.class); // * Валидный пример с добавлением @BeforeTest @AfterTest
                                                     // * @CsvSource добавлена, но без отдельных проверок.
    }
}