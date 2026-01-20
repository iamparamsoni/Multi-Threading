package Basics;

public class App4 {

    public static void main(String[] args) {
        var t1 = new Thread(new Thread1());
        t1.start();
        for (Thread t : Thread.getAllStackTraces().keySet()){
            System.out.println("Thread : " + t.getName() + " State : "+ t.getState());
        }
    }
}

class Thread1 extends Thread{
    @Override
    public void run(){
        System.out.println("Thread : " + this.getName() + " started");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("*******Thread*******");
    }

}

