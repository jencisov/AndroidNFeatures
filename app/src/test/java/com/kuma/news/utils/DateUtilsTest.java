package com.kuma.news.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jorge.Enciso on 31/03/2017.
 */
public class DateUtilsTest {
    String correctInputDate1 = "2016-07-25T09:56:27Z";
    String correctOutputDate1 = "lun, 25 jul 2016 09:56";

    @Test
    public void formatNewsApiDate_correctDate_outputsCorrectDate() {
        String outputDate = DateUtils.formatNewsApiDate(correctInputDate1);
        assertEquals(outputDate, correctOutputDate1);
    }

    @Test
    public void formatNewsApitDate_nullInput_outputsNull() {
        String outputDate = DateUtils.formatNewsApiDate(null);
        assertEquals(outputDate, null);
    }

}