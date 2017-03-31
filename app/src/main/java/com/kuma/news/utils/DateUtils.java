package com.kuma.news.utils;

import com.google.firebase.crash.FirebaseCrash;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jorge.Enciso on 30/03/2017.
 */
public class DateUtils {

    public static String formatNewsApiDate(String inputDate) {
        try {
            String inputDateFormat = "yyyy-MM-dd'T'HH:mm:sss'Z'";
            String outputDateFormat = "EEE, d MMM yyyy KK:mm";

            SimpleDateFormat inputFormat = new SimpleDateFormat(inputDateFormat);
            SimpleDateFormat outputFormat = new SimpleDateFormat(outputDateFormat);

            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            FirebaseCrash.report(e);
        }
        return inputDate;
    }

}