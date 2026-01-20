package Basics;

public class TaskPriority {

    public static void main(String[] args) {
        var low = new Thread(new ThreadPriority(),"lowPriorityThread");
        var normal = new Thread(new ThreadPriority(),"normalPriorityThread");
        var high = new Thread(new ThreadPriority(),"highPriorityThread");
        low.setPriority(Thread.MIN_PRIORITY);
        normal.setPriority(Thread.NORM_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);
        low.start();
        normal.start();
        high.start();
    }
}

class ThreadPriority implements Runnable{

    @Override
    public void run() {
        for (int i = 0 ; i <= 5 ; i++){
            System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().getPriority());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


