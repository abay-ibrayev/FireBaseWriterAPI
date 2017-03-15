package kz.fa.firebasewriter.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.DateBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

/**
 * Created by abay on 2/15/17.
 */
public class CronExpressionsExample {
    private static final  String GROUP_NAME = "CroneExamples";
    public  static Trigger fireAfterSomeTime(int startHr, int startMin, int startSec, int nowMin, int nowHr){
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("fireAfterAMinStartingAt", GROUP_NAME)
                .startAt(DateBuilder.todayAt(startHr, startMin, startSec))
                .withSchedule(cronSchedule("hello","4 27 11 15 9 ? 2017"))
                .build();
        return trigger;

    }
    private static CronScheduleBuilder cronSchedule(String desc, String cronExpression) {
        System.out.println(desc + "->(" + cronExpression + ")");
        return CronScheduleBuilder.cronSchedule(cronExpression);
    }

}
