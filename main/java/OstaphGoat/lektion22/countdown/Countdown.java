package OstaphGoat.lektion22.countdown;

public class Countdown {

    public static void starteCountdown(String threadName){
        for(int i = 5; i >= 0; i--){
            System.out.println(threadName + ": " + i);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println("Thread interrupted");
            }
        }
    }
}
