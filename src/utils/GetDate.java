/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Mateus Oliveira
 */
public class GetDate {

    public GetDate() {

    }

    public String formatYear() {
        DateFormat dateFormatYear = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String dateYear = dateFormatYear.format(date);
        return dateYear;
    }

    public String formatMonth() {
        DateFormat dateFormatMonth = new SimpleDateFormat("MM");
        Date date = new Date();
        String dateMonth = dateFormatMonth.format(date);
        return dateMonth;
    }

    public String formatDay() {
        DateFormat dateFormatDay = new SimpleDateFormat("dd");
        Date date = new Date();
        String dateDay = dateFormatDay.format(date);
        return dateDay;
    }


    public String getProximoDiaUtil() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int dayOfWeek;
        do {
            cal.add(Calendar.DAY_OF_MONTH, +1);
            dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        } while (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);

        return dateFormat.format(cal.getTime());

    }

    public String formataData(String String) {  // format data on case of hifens instead of bars
        String = String.replace("-", "/");
        String[] formata = String.split("/");
        String = formata[2] + "/" + formata[1] + "/" + formata[0];
        return String;
    }

}
