package inno.java.pro.lesson6;



public class Main {


    public static void main(String[] args) throws InterruptedException {
        var myThreadPool = new MyThreadPool(10);
        myThreadPool.execute(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Первый в очереде 1");
        });
        myThreadPool.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Первый в очереде 2");
        });
        myThreadPool.execute(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Первый в очереде 3");
        });

        myThreadPool.execute(() -> {
            try {
                Thread.sleep(13000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Первый в очереде 4");
        });

        myThreadPool.execute(() -> {
            try {
                Thread.sleep(13000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Первый в очереде 5");
        });
        myThreadPool.shutdown();

        while (!myThreadPool.awaitTermination()){
            Thread.sleep(1000);
            System.out.println("Ждем завершения всех потоков и всех задач в очереде.");
        }
        System.out.println("Все задачи и работы в поле поток завершены.");
        myThreadPool.execute(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Первый в очереде 6");
        });

    }
}


