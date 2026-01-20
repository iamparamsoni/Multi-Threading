package Basics;

public class App2 {

    public static void main(String[] args) {
        var t1 = new RunnerA(); //var = Thread
        var t2 = new RunnerB();
        t1.start();
        t2.start();
    }
}

class RunnerA extends Thread{

    @Override
    public void run() {
        for (int i = 1 ; i<= 10 ; i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner1 : " + i);
        }
    }
}

class RunnerB extends Thread{

    @Override
    public void run() {
        for (int i = 1 ; i<= 10 ; i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner2 : " + i);
        }
    }
}


