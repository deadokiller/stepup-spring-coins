package org.lesson2.examples;

import org.lesson2.annotation.AfterSuite;
import org.lesson2.annotation.BeforeSuite;

public class Lesson2Example6 {
    @AfterSuite
    private static void test1() {
        System.out.println("test1");
    }

    @AfterSuite
    private static void test2() {
        System.out.println("test2");
    }
}
