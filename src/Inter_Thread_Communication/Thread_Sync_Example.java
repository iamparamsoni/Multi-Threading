package Inter_Thread_Communication;

public class Thread_Sync_Example {
    private int counter1;
    private int counter2;

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void increment1(){
        // Synchronization block
        // executes operations before
        synchronized (lock1) {
            counter1++;
        }
        // execute operations after
    }

    public void increment2(){
        // Synchronization block
        // executes operations before
        synchronized (lock2) {
            counter2++;
        }
        // execute operations after
    }

    public void execute(){
        var t1 = new Thread(
                () -> {
                    for (int i = 0; i < 1000 ; i++){
                        increment1();
                    }
                }
        );
        var t2 = new Thread(
                () -> {
                    for (int i = 0; i < 1000 ; i++){
                        increment2();
                    }
                }
        );
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        var obj1 = new Thread_Sync_Example();
        obj1.execute();

        System.out.println("Counter 1 : " + obj1.counter1);
        System.out.println("Counter 2 : " + obj1.counter2);
    }
}
