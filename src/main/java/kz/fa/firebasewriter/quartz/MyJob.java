package kz.fa.firebasewriter.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by abay on 2/15/17.
 */
public class MyJob implements Job {
    private  static int count;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Starting job: "+ jobExecutionContext.getFireTime());
        JobDetail detail = jobExecutionContext.getJobDetail();
        System.out.println("Example name is: "+ detail.getJobDataMap().getString("example"));
        System.out.println("Job ending: "+ jobExecutionContext.getJobRunTime() + " , key: "+ detail.getKey());
        System.out.println("Job next execute: "+ jobExecutionContext.getNextFireTime());
        ILatch latch = (ILatch) detail.getJobDataMap().get("latch");
        latch.countDown();
        count++;
        System.out.println("Job counts: " + count);
    }
}
