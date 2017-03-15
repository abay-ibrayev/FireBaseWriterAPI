package kz.fa.firebasewriter.quartz;

import org.quartz.*;

import java.util.*;
import java.util.Calendar;
import java.util.concurrent.CountDownLatch;

/**
 * Created by abay on 2/15/17.
 */

public class QuartzSchedulerCronTriggerExample implements ILatch{
    private CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        QuartzSchedulerCronTriggerExample quartzScheduler = new QuartzSchedulerCronTriggerExample();
        quartzScheduler.fireJob();
    }

    public void fireJob() throws SchedulerException,InterruptedException {
        SchedulerFactory factory = new org.quartz.impl.StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        JobBuilder builder = JobBuilder.newJob(MyJob.class);
        JobDataMap data = new JobDataMap();
        data.put("latch",this);
        JobDetail detail = builder.usingJobData("example", " kz.fa.firebasewriter.quartz.QuartzSchedulerListenerExample")
                                .usingJobData(data)
                                .withIdentity("MyJob","group1")
                                .build();
        java.util.Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        int min = rightNow.get(Calendar.MINUTE);
        System.out.println("Current time: "+ new Date());
        scheduler.scheduleJob(detail,CronExpressionsExample.fireAfterSomeTime(10,15,30,hour, min));
        latch.await();
        System.out.println("All triggers are executed");
        scheduler.shutdown();

    }


    @Override
    public void countDown() {
        latch.countDown();
    }
}
