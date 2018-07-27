package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatTime {

	public static String main(String[] args, String input_dateTime, String datetype) throws Exception {
		/* 2018-07-26 --> 07-26-2018 */
		/*
		 * String date_s = "2018-07-26"; SimpleDateFormat dt = new
		 * SimpleDateFormat("yyyy-mm-dd"); Date date_1 = dt.parse(date_s);
		 * SimpleDateFormat dt1 = new SimpleDateFormat("mm-dd-yyyy");
		 * System.out.println(dt1.format(date_1));
		 * 
		 * 2018-07-09 23:47:40.727161 --> 07/09/2018 @ 23:47:40 String date_2 =
		 * "2018-07-09 23:47:40.727161"; SimpleDateFormat dt_2 = new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); Date dateParse_date_2 =
		 * dt_2.parse(date_2); SimpleDateFormat simpleFormat_dt2 = new
		 * SimpleDateFormat("MM/dd/yyyy @ HH:mm:ss");
		 * System.out.println(simpleFormat_dt2.format(dateParse_date_2));
		 */

		 input_dateTime = "2018-07-09 23:47:40.727161";
		 datetype = "yyyy-MM-dd HH:mm:ss";
		Date input_dateTime_Parse = null;
		SimpleDateFormat simpleFormat_dt = null;
		switch (datetype) {
		case "yyyy-MM-dd HH:mm:ss":
			SimpleDateFormat input_dateTime_Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			input_dateTime_Parse = input_dateTime_Format.parse(input_dateTime);
			simpleFormat_dt = new SimpleDateFormat("MM/dd/yyyy @ HH:mm:ss");
			System.out.println(simpleFormat_dt.format(input_dateTime_Parse));
			System.out.println("SimpleDateFormat =" + simpleFormat_dt);
			break;
		case "yyyy-mm-dd":
			SimpleDateFormat input_dateTime_Format_1 = new SimpleDateFormat("yyyy-mm-dd");
			input_dateTime_Parse = input_dateTime_Format_1.parse(input_dateTime);
			simpleFormat_dt = new SimpleDateFormat("mm-dd-yyyy");
			System.out.println(simpleFormat_dt.format(input_dateTime_Parse));
			System.out.println("SimpleDateFormat =" + simpleFormat_dt);
			break;

		}
		return simpleFormat_dt.format(input_dateTime_Parse).toString();

	}

}
