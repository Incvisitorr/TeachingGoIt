package Task12_1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task12_1 {
    public static void main(String[] args) {
        ScheduledExecutorService sEs= Executors.newScheduledThreadPool(2);
        sEs.scheduleAtFixedRate(
                ()-> System.out.println(System.currentTimeMillis()),
                0,
                1,
                TimeUnit.SECONDS
        );
        sEs.scheduleAtFixedRate(
                ()-> System.out.println("Минуло 5 секунд"),
                4,
                5,
                TimeUnit.SECONDS
        );
    }
}
