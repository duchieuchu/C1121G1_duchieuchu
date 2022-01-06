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
        StopWatch stopWatch= new StopWatch();
//        long[] array = new long[100000];
//
//        for (int i = 0; i < array.length; i++) {
//            array[i] = (long) Math.floor(Math.random() * 100000);
//        }
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1.bat dau");
            System.out.println("2.ket thuc");
            System.out.println("3.ket qua");
            System.out.println("0.exit");
            System.out.println("Enter your choice");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    Date now1 = new Date();//lay ra thoi gian hien tai
                    System.out.println("Now is"+now1);
                break;
                case 2:
                    Date now2 = new Date();//lay ra thoi gian hien tai
                    System.out.println("Now is"+now2);
                    break;
                case 3:

            }
        }
        Date now = new Date();//lay ra thoi gian hien tai
        System.out.println("Now is"+now);

//        System.out.println("startTime: "+stopWatch.startTime);
//        System.out.println("endTime: "+stopWatch.endTime);
//        System.out.println("elapsedTime: "+stopWatch.elapsedTime);

    }


}


