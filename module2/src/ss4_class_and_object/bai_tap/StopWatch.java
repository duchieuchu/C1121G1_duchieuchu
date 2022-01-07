package ss4_class_and_object.bai_tap;

import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void end() {
        endTime = System.currentTimeMillis();
    }

    long elapsedTime;

    public long elapsedTime() {
        elapsedTime = endTime - startTime;
        return elapsedTime;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        long[] array = new long[10000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (long) Math.floor(Math.random() * 10000000);
        }

        stopWatch.end();

        System.out.println("elapsedTime: " + stopWatch.elapsedTime());

    }
}





