package org.lesson2.examples;

import org.lesson2.annotation.AfterSuite;
import org.lesson2.annotation.AfterTest;
import org.lesson2.annotation.BeforeSuite;
import org.lesson2.annotation.BeforeTest;
import org.lesson2.annotation.CsvSource;
import org.lesson2.annotation.Test;

public class Lesson2Example11 {
    @Test
    private void test5() {
        System.out.println("Lesson2Example11 : test5");
    }

    @AfterSuite
    private static void afterSuite() {
        System.out.println("Lesson2Example11 : afterSuite");
    }

    @BeforeSuite
    private static void beforeSuite() {
        System.out.println("Lesson2Example11 : beforeSuite");
    }

    @Test(priority = 7)
    @CsvSource(source = "10, Java, 20, true")
    private void test7(int a, String b, int c, boolean d) {
        System.out.println("Lesson2Example11 : test7:" + a + b + c + d);
    }

    @Test(priority = 6)
    private void test6() {
        System.out.println("Lesson2Example11 : test6");
    }

    @BeforeTest
    private void beforeTest1() {
        System.out.println("Lesson2Example11 : beforeTest1");
    }

    @BeforeTest
    private void beforeTest2() {
        System.out.println("Lesson2Example11 : beforeTest2");
    }

    @AfterTest
    private void afterTest1() {
        System.out.println("Lesson2Example11 : afterTest1");
    }

    @AfterTest
    private void afterTest2() {
        System.out.println("Lesson2Example11 : afterTest2");
    }
}
