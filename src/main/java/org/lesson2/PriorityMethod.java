package org.lesson2;

import java.lang.reflect.Method;

public class PriorityMethod {
    private Method method;
    private int priority;

    public PriorityMethod(Method method, int priority) {
        this.method = method;
        this.priority = priority;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
