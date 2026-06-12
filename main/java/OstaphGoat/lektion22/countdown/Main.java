package OstaphGoat.lektion22.countdown;

import static OstaphGoat.lektion22.countdown.Countdown.starteCountdown;

public class Main {
    public static void main(String[] args) {
        System.out.println("--Start--");
        //1. Thread über vererbung
        Thread t1 = new ErbenderThread();
        //2. Thread über Runnable
        Thread t2 = new Thread(new MeinRunnable());
        //3. über anonyme klasse
        Thread t3 = new Thread(){
            @Override
            public void run(){
                System.out.println("3. Anonym");
            }
        };
        //4. Thread über Lamda
        Thread t4 = new Thread(() -> starteCountdown("4.lamda"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
