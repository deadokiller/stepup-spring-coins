package org.lesson2.examples;

import org.lesson2.annotation.BeforeSuite;
import org.lesson2.annotation.Test;

public class Lesson2Example5 {
    @BeforeSuite
    private static void test1() {
        System.out.println("test1");
    }

    @BeforeSuite
    private static void test2() {
        System.out.println("test2");
    }
}
