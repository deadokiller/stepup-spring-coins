package inno.java.pro.lesson6;

import java.util.Collections;
import java.util.LinkedList;

public class MyThreadPool {
    private final LinkedList<Runnable> queue = new LinkedList<>();
    private final Object sync = new Object();
    private boolean isAlive = true;
    private int curThreadCount = 0;
    private int capacity;

    public MyThreadPool(int capacity) {
        this.capacity = capacity;
        for (int i = 0; i < capacity; i++) {
            new MyThread().start();
            curThreadCount++;
        }
    }

    private class MyThread extends Thread {

        @Override
        public void run() {
            while (isAlive || !queue.isEmpty()) {
                try {
                    Runnable run;
                    synchronized (sync) {
                        while (queue.isEmpty()) {
                            sync.wait();
                        }
                        run = queue.getFirst();
                        queue.remove(run);
                    }
                    run.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            curThreadCount--;
        }
    }

    public void shutdown() {
        isAlive = false;
        for (int i = 0; i < capacity; i++) {
            synchronized (sync) {
                queue.add(() -> {
                    System.out.println("Останавливаем пул потоков(ядовитая пилюля)");
                });
                sync.notifyAll();
            }
        }
    }

    public void execute(Runnable r) {
        if (curThreadCount == 0) {
            throw new IllegalArgumentException("Пул потоков остановлен, активных потоков в пуле не осталось");
        }
        if (!isAlive) {
            throw new IllegalArgumentException("Пул потоков в процессе остановки, новые задания не принимаются, выполняются, только те что в очереде");
        } else {
            synchronized (sync) {
                queue.add(r);
                sync.notifyAll();
            }
        }
    }

    public boolean awaitTermination() {
        return !isAlive && queue.isEmpty() && curThreadCount == 0;
    }
}
