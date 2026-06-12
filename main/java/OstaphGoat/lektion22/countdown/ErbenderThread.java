package OstaphGoat.lektion22.countdown;


import static OstaphGoat.lektion22.countdown.Countdown.starteCountdown;

public class ErbenderThread extends Thread {
    //von thread erben
    @Override
    public void run() {
        starteCountdown("1 Vererbung");
    }

}
