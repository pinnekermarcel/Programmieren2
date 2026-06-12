package OstaphGoat.lektion22.countdown;

import static OstaphGoat.lektion22.countdown.Countdown.starteCountdown;

public class MeinRunnable implements Runnable{
    @Override
    public void run() {
        starteCountdown("2. Runnable");
    }

}
