package Basics;

public class App {

    public static void main(String[] args) {

//        var runner1 = new Runner1();
//        var runner2 = new Runner2();
//        runner1.execute();
//        runner2.execute();

        //We can define the Runnable in form of Lambda expressions too
        Runnable r3 = () -> {
            for (int i = 1 ; i<= 10 ; i++){
                System.out.println("Runner3 : " + i);
            }
        };

        var t1 = new Thread(new Runner1());
        var t2 = new Thread(new Runner2());
        var t3 = new Thread(r3);
        var t4 = new Thread(
                () -> {
                    for (int i = 1 ; i<= 10 ; i++){
                        System.out.println("Runner4 : " + i);
                    }
                }
        );

        //Whenever we call the start method it allocates system resources for the new thread and it calls the thread run method in a new call stack.

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}


class Runner1 implements Runnable{

//    void execute(){
//        for (int i = 1 ; i<= 10 ; i++){
//            System.out.println("Runner1 : " + i);
//        }
//    }

    @Override
    public void run() {
        for (int i = 1 ; i<= 10 ; i++){
            System.out.println("Runner1 : " + i);
        }
    }
}


class Runner2 implements Runnable{

//    void execute(){
//        for (int i = 1 ; i<= 10 ; i++){
//            System.out.println("Runner2 : " + i);
//        }
//    }

    @Override
    public void run() {
        for (int i = 1 ; i<= 10 ; i++){
            System.out.println("Runner2 : " + i);
        }
    }
}

