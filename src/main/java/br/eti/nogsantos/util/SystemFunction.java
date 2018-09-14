package br.eti.nogsantos.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

/**
 * @author Fabricio Nogueira - nogsantos
 * @since Dec 12, 2014
 */
public class SystemFunction {
    /**
     * Initial message for login.
     *
     * @return greeting
     */
    public String greetingTime() {
        Properties properties = new Properties();
        GregorianCalendar todaysDate = new GregorianCalendar();
        int hour, minute, hour_of_day, am_pm;
        hour = todaysDate.get(Calendar.HOUR);
        hour_of_day = todaysDate.get(Calendar.HOUR_OF_DAY);
        minute = todaysDate.get(Calendar.MINUTE);
        am_pm = todaysDate.get(Calendar.AM_PM);
        String message = "";
        if (hour_of_day <= 11) {
            message = properties.getProperty("tit.good_morning");
        }
        if (hour_of_day >= 12 && hour_of_day <= 17) {
            message = properties.getProperty("tit.good_afternoon").toString();
        }
        if (hour_of_day >= 18 && hour_of_day < 22) {
            message = properties.getProperty("tit.good_evening").toString();
        }
        if (hour_of_day >= 23) {
            message = properties.getProperty("tit.good_night").toString();
        }
        return message;
    }

    /**
     * Sha1 function
     *
     * @param x
     * @return
     * @throws java.lang.Exception
     */
    public static byte[] sha1(String x) throws Exception {
        java.security.MessageDigest d = null;
        d = java.security.MessageDigest.getInstance("SHA-1");
        d.reset();
        d.update(x.getBytes());
        return d.digest();
    }
}