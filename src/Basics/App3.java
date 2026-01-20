package Basics;

public class App3 {

    public static void main(String[] args) {
        var t1 = new Thread(new RunnerX());
        var t2 = new Thread(new RunnerY());
        t1.start();
        t2.start();
        System.out.println("**Main Thread without join**");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("**Main Thread with join**");
    }
}


class RunnerX extends Thread{

    @Override
    public void run(){
        try {
            Thread.sleep(10000);
            for (int i = 1; i <= 10; i++) {
                System.out.println("RunnerX : " + i);
            }
        }
        catch (InterruptedException e){
            System.out.println("Exception");
        }
    }

}

class RunnerY extends Thread{

    @Override
    public void run(){
        for (int i = 1 ; i<= 10 ; i++){
            System.out.println("RunnerY : " + i);
        }
    }

}




