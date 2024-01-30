package org.lesson2.examples;

import org.lesson2.annotation.AfterSuite;
import org.lesson2.annotation.BeforeSuite;
import org.lesson2.annotation.Test;

public class Lesson2Example8 {
    @Test
    private void test5() {
        System.out.println("Lesson2Example8 : test5");
    }

    @AfterSuite
    private static void afterSuite() {
        System.out.println("Lesson2Example8 : afterSuite");
    }

    @BeforeSuite
    private static void beforeSuite() {
        System.out.println("Lesson2Example8 : beforeSuite");
    }

    @Test(priority = 6)
    private void test6() {
        System.out.println("Lesson2Example8 : test6");
    }

    @Test(priority = 1)
    private void test1() {
        System.out.println("Lesson2Example8 : est1");
    }

    @Test(priority = 5)
    private void test55() {
        System.out.println("Lesson2Example8 : test5");
    }

    @Test(priority = 10)
    private void test10() {
        System.out.println("Lesson2Example8 : test10");
    }

    @Test(priority = 7)
    private void test7() {
        System.out.println("Lesson2Example8 : test7");
    }
}
