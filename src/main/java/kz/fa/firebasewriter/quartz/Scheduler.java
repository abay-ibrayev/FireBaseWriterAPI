package kz.fa.firebasewriter.quartz;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.Calendar;

/**
 *
 * @author Bagdat
 */
@Singleton
public class Scheduler {

    private String restURL = "http://192.168.7.16:2080/attback/ws/rest";
    private int firstDay = 0;

    @Schedule(dayOfMonth = "2-31", dayOfWeek = "Tue-Sat", hour = "0", minute = "0", second = "1", persistent = false)
    public void doAtTime() {

        Calendar cal = Calendar.getInstance();
        int res = 0;
        HttpResponse<String> response = null;
//
//        try {
//            response = Unirest.post("http://192.168.7.20:30080/attback/ws/rest/prepareDB")
//                    .header("content-type", "application/x-www-form-urlencoded")
//                    .asString();
//        } catch (UnirestException ex) {
//            Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
//        }

        try {
            response = Unirest.post(restURL + "/incrProp")
                    .header("content-type", "application/x-www-form-urlencoded")
                    .asString();
            res = Integer.parseInt(response.getBody());
            if (res == 1) {
                System.out.println("Проинкрементированы все пользователи успешно");
            } else {
                System.out.println("Произошла ошибка, проинкрементированы не все пользователи");
            }
        } catch (UnirestException ex) {
            Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            response = Unirest.post(restURL + "/checkEditGoneTime")
                    .header("content-type", "application/x-www-form-urlencoded")
                    .asString();
        } catch (UnirestException ex) {
            Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            response = Unirest.post(restURL + "/updateAllUsers")
                    .header("content-type", "application/x-www-form-urlencoded")
                    .body("ldate=" + Calendar.getInstance().getTimeInMillis())
                    .asString();
        } catch (UnirestException ex) {
            Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
        }

        sendMSG();
    }

    @Schedule(dayOfMonth = "1", hour = "0", minute = "0", second = "1", persistent = false)
    public void doAtFirstDay() {
        HttpResponse<String> response = null;
        try {
            response = Unirest.post(restURL + "/prepareDB")
                    .header("content-type", "application/x-www-form-urlencoded")
                    .asString();
        } catch (UnirestException ex) {
            Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar cal = Calendar.getInstance();
        switch (cal.get(Calendar.DAY_OF_WEEK)) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                doAtTime();
            default:
                sendMSG();
        }
    }

    private void sendMSG() {
        HttpResponse<String> response = null;
        try {
            response = Unirest.post(restURL + "/sendDaylyReport")
                    .header("content-type", "application/x-www-form-urlencoded")
                    .asString();
            System.out.println("Отправлены все письма");
        } catch (UnirestException ex) {
            System.out.println("Проиошла ошибка приотправке писем");
            Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
