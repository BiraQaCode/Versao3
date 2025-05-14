package br.sp.UbiraProject.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {

	public static Date obterDataComDiferencaDias(int dias) {
		//retorna a data do Java
		Calendar calendar = Calendar.getInstance(); //instancia do calendar que aponta para a data atual
		calendar.add(Calendar.DAY_OF_MONTH, dias); //add a qtde de dias � data atual
		return calendar.getTime();
	}
	
	public static String ObterDataFormatada (Date data) {
		//retorna o formato da data
		DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		return format.format(data);
	}
}
