package test;

import java.text.DecimalFormat;

public class AddZeroBeforeNumber {

	public static void main(String[] args) {
		int number = 8888;        
		String str = String.format("%02d", number);  // 0009      
		System.out.printf("original number %d, numeric string with padding: %s", number, str); 
		
		
		//DecimalFormat df = new DecimalFormat("0000");
		DecimalFormat df = new DecimalFormat("#0.000");  ///-> a=99.000
		double nbr = 0.03; 
		String c = df.format(nbr);   // 0009
		 String a = df.format(99);  // 0099
		 String b = df.format(999); // 0999
		 System.out.println("String a = "+ a);
		 System.out.println("String b = "+ b);
		 System.out.println("String c = "+ c);
		 
		 
		 
		 int quantity = 220;
		 
	        // %08 means total length of number would be 8
	        // if number is of 3 digits, rest of them will
	        // be padded by leading zeros.
	        String padded = String.format("%08d", quantity);
	        System.out.println("Number padded with leading zero : " + padded);
	 
	        System.out.printf("4 digit number padded with zero to make 6 digit : %06d %n", 4001);
	 
	        // You can also display hexadecimal number padded by zero
	        // just replace %d with %x, as shown below
	        System.out.printf("2 digit hexadecimal number padded with zero : %06x %n", 0xBE);
	 
	        // Another way to left pad a number is by using DecimalFormat class
	        // Below format will make String 6 digit long
	        // if number is less than 6 digit long, it will be padded by
	        // leading zero.
	        DecimalFormat df1 = new DecimalFormat("000000");
	        System.out.println("Number formatted using DecimalFormat = " + df1.format(23));

	}

}
