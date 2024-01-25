package org.lesson2.examples;

import org.lesson2.annotation.AfterSuite;
import org.lesson2.annotation.BeforeSuite;

public class Lesson2Example2 {

    @AfterSuite
    public void test(){
        System.out.println("test");
    }
}
