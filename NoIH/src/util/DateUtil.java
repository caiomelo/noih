/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Caio
 */
public class DateUtil {

    private static String DATE_REGEX = "\\d{1,2}/\\d{1,2}/\\d{4}";
    private static int HORAS = 12;
    private static int MINUTOS = 0;
    private static int SEGUNDOS = 0;

    private static boolean isValidDate(String date) {
        boolean result = false;
        GregorianCalendar data = getGregorianCalendarDate(date);
        GregorianCalendar now = new GregorianCalendar();
        if (now.compareTo(data) <= 0) {
            result = true;
        }

        return result;
    }

    public static boolean isValidTimeGap(String dataInicio, String dataFinal) {
        boolean result = false;

        if (isValidDate(dataInicio) && isValidDate(dataFinal)) {
            GregorianCalendar dataIn = getGregorianCalendarDate(dataInicio);
            GregorianCalendar dataFin = getGregorianCalendarDate(dataFinal);

            if (dataIn.compareTo(dataFin) < 0) {
                result = true;
            }
        }

        return result;
    }

    private static int[] getDate(String date) {
        int[] result = {0, 0, 0};
        if (date.matches(DATE_REGEX)) {
            String[] datePieces = date.split("/");
            int dia = Integer.parseInt(datePieces[0]);
            int mes = Integer.parseInt(datePieces[1]);
            int ano = Integer.parseInt(datePieces[2]);
            result[0] = dia;
            result[1] = mes;
            result[2] = ano;
        }
        return result;
    }

    public static GregorianCalendar getGregorianCalendarDate(String date) {
        int[] dateInts = getDate(date);
        int dia = dateInts[0];
        int mes = dateInts[1];
        int ano = dateInts[2];

        GregorianCalendar data = new GregorianCalendar();
        data.set(Calendar.YEAR, ano);
        data.set(Calendar.MONTH, mes);
        data.add(Calendar.MONTH, -1);
        data.set(Calendar.DAY_OF_MONTH, dia);
        data.set(Calendar.HOUR_OF_DAY, HORAS);
        data.set(Calendar.MINUTE, MINUTOS);
        data.set(Calendar.SECOND, SEGUNDOS);
        return data;
    }
}
