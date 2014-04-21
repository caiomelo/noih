package br.ufc.edeajr.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Teste {
	public static void main(String[] args) {
		String tel = "(85)9999-2125";
		String padrao = "\\([0-9]{2}\\)(9)?[0-9]{4}-[0-9]{4}";
		Pattern pattern = Pattern.compile(padrao);
		Matcher matcher = pattern.matcher(tel);
		System.out.println(matcher.find());
		System.out.println(matcher.group());
		//String formato = "\\d([0-9]{2})\\d[0-9]{4}-\\d[0-9]{4}"; 
        
	}
}
