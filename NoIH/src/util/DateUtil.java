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
        int[] dateInts = getDate(date);
        int dia = dateInts[0];
        int mes = dateInts[1] - 1; //some weird behaviour from GregorianCalendar constructor below
        int ano = dateInts[2];

        GregorianCalendar now = new GregorianCalendar();
        if (now.compareTo(data) <= 0) {
            result = true;
        }

        return result;
    }

    public static boolean isValidTimeGap(String dataInicio, String dataFinal) {
        boolean result = false;

        if (isValidDate(dataInicio) && isValidDate(dataFinal)) {
            int[] ini = getDate(dataInicio);
            Calendar dataIn = new GregorianCalendar(ini[2], ini[1] - 1, ini[0], HORAS, MINUTOS, SEGUNDOS);
            int[] fim = getDate(dataFinal);
            Calendar dataFin = new GregorianCalendar(fim[2], fim[1] - 1, fim[0], HORAS, MINUTOS, SEGUNDOS);

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
        int mes = dateInts[1] - 1; //some weird behaviour from GregorianCalendar constructor below
        int ano = dateInts[2];

        GregorianCalendar data = new GregorianCalendar(ano, mes, dia, HORAS, MINUTOS, SEGUNDOS);
        return data;
    }
}
