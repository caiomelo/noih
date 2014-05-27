/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import model.Apartamento;
import model.Reserva;
import util.DateUtil;

/**
 *
 * @author RodriguesMoises
 */
public class Util {

    public static String formatGregorianCalendar(GregorianCalendar gregorianCalendar) {
        Date date = gregorianCalendar.getTime();
        return date.getDay() + "-" + (date.getMonth() + 1) + "-" + (date.getYear() + 1900);
    }

    public static String changeDayforMonth(String date) {
        String auxStr = "";
        if (date.length() == 10) {
            if (date.charAt(2) == '/' && date.charAt(5) == '/') {
                auxStr += date.charAt(3);
                auxStr += date.charAt(4);
                auxStr += date.charAt(2);
                auxStr += date.charAt(0);
                auxStr += date.charAt(1);
                auxStr += date.charAt(5);
                auxStr += date.charAt(6);
                auxStr += date.charAt(7);
                auxStr += date.charAt(8);
                auxStr += date.charAt(9);
            }
        }
        return auxStr;
    }

    public static String formatDate(String date) {
        String string = "";
        if (date.charAt(4) == '-' && date.charAt(7) == '-') {
            /*string = "" + date.charAt(8) + date.charAt(9) + "/" + date.charAt(5) + date.charAt(6) + "/" + date.charAt(0) +
             date.charAt(1) + date.charAt(2) + date.charAt(3);*/
            string += date.charAt(8);
            string += date.charAt(9);
            string += "/";
            string += date.charAt(5);
            string += date.charAt(6);
            string += "/";
            string += date.charAt(0);
            string += date.charAt(1);
            string += date.charAt(2);
            string += date.charAt(3);
        }
        return string;
    }

    public static String formatCPF(long cpf) {
        String str = "" + cpf;
        str = (str.length() < 11) ? 0 + str : str;
        return str;
    }

    public static void fillObject(Object object) {
        Method methods[] = object.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().contains("set")) {
                /*System.out.println("");
                 System.out.println(methods[i].getName());
                 System.out.println(methods[i].getParameterTypes()[0]);*/
                try {
                    if (methods[i].getParameterTypes()[0].toString().equals("class java.lang.String")) {
                        methods[i].invoke(object, methods[i].getName().substring(3));
                    } else {
                        if (methods[i].getParameterTypes()[0].toString().equals("long")
                                || methods[i].getParameterTypes()[0].toString().equals("int")
                                || methods[i].getParameterTypes()[0].toString().equals("double")
                                || methods[i].getParameterTypes()[0].toString().equals("float")) {
                            methods[i].invoke(object, i + 20);
                        } else {
                            if (methods[i].getParameterTypes()[0].toString().equals("class java.util.Date")) {
                                methods[i].invoke(object, new Date());
                            } else {
                                if (methods[i].getParameterTypes()[0].toString().equals("class java.util.GregorianCalendar")) {
                                    methods[i].invoke(object, new GregorianCalendar());
                                } else {
                                    Object field = methods[i].getParameterTypes()[0].getConstructors()[0].newInstance();
                                    methods[i].invoke(object, field);
                                    fillObject(field);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    public static byte[] readBytesFromFile(String fileName) {
        byte[] bytes = null;
        try {
            File file = new File(fileName);
            bytes = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytes);
            fileInputStream.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return bytes;
    }

    public static void saveFileFromBytes(String fileName, byte[] bytes) {
        try {
            /*FileWriter fileWriter = new FileWriter(new File(fileName));
             for(byte b : bytes)
             {
             fileWriter.write(b & 0xFF);// & 0xFF conversao correta de byte para int
             }
             fileWriter.close();*/

            /*BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             for(byte b : bytes)
             {
             bufferedWriter.write(b);
             }
             bufferedWriter.close();*/

            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(bytes);
            fos.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<Apartamento> getVacant(long reservaId, List<Reserva> reservas, List<Apartamento> todosApartamentos, String dataInicio, String dataFim) {
        List<Apartamento> apartamentos = new ArrayList<Apartamento>();
        GregorianCalendar dataI = DateUtil.getGregorianCalendarDate(dataInicio);
        GregorianCalendar dataF = DateUtil.getGregorianCalendarDate(dataFim);

        for (Apartamento apartamento : todosApartamentos) {
            boolean estaLivre = true;
            for (Reserva reserva : reservas) {
                if ((reserva.getApartamento().getId() == apartamento.getId()) && (reservaId != reserva.getId())) {
                    if (((dataI.compareTo(reserva.getDataFim()) < 0) && (dataI.compareTo(reserva.getDataInicio())) >= 0)
                            || ((dataF.compareTo(reserva.getDataInicio()) > 1) && (dataF.compareTo(reserva.getDataFim()) < 0))) {
                        estaLivre = false;
                    }
                }
            }
            if (estaLivre) {
                apartamentos.add(apartamento);
            }
        }

        return apartamentos;
    }
}
