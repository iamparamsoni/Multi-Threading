package Basics;

public class Worker {

    public static void main(String[] args) {


        // JVM does not kill user/worker threads !!!
        // When we create normal thread or a user thread, then it is a so-called foreground thread with high priority
        var t1 = new Thread(new NormalWorker());
        var t2 = new Thread(new DaemonWorker());
        t2.setDaemon(true);
        //If there are no user or worker threads in the JVM, it terminates the application
        //JVM doesn’t kill the daemon thread directly — it kills itself, and all daemon threads die with it
        System.out.println("t1 is Daemon Thread : " + t1.isDaemon());
        System.out.println("t1 is Daemon Thread : " + t2.isDaemon());
        t1.start();
        t2.start();
    }

}

class DaemonWorker implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("Daemon Thread is executing !!");
        }
    }
}


class NormalWorker implements Runnable{

    @Override
    public void run() {
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e){
                System.out.println("Error");
            }
            System.out.println("********************************");
            System.out.println("Executing normal thread !!");
            System.out.println("********************************");
    }
}

