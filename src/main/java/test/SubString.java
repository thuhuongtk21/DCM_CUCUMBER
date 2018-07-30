package test;

public class SubString {

	public static void main(String[] args) {
		String text = "DSD  00000087606300203        ";
		String text_sub = text.substring(6);
		System.out.println("Sub text = "+text_sub);
		String remove_zero = text_sub.replaceFirst("^0+(?!$)", "");
		System.out.println("Remove leading zero = "+ remove_zero);

	}

}
