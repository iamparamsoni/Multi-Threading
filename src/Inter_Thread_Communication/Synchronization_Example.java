package Inter_Thread_Communication;

public class Synchronization_Example {

    public static int counter = 0;

    // incrementing an integer is not an atomic process
    static synchronized void increment(){
        counter++;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(
                () -> {
                    for (int i = 0 ; i <1000 ; i++){
                        increment();
                    }
                }
        );
        Thread t2 = new Thread(
                () -> {
                    for (int i = 0 ; i <1000 ; i++){
                        increment();
                    }
                }
        );
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("Counter : " + counter);
    }
}
