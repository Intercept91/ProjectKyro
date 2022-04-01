package com.kyro.projectmanagement.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	private static String formatter = "dd-MM-yyyy";

	public static Date convertStringToDate(String date) {
		try {
			return new SimpleDateFormat(formatter).parse(date);

		} catch (ParseException pe) {
			return new Date();
		}
	}

	public static String convertDateToString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat(formatter);
		return dateFormat.format(date);
	}

	public static Date getTotalDays(int days, Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		return date = c.getTime();
	}

}
