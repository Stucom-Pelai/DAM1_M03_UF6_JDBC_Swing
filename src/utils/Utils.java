package utils;

public class Utils {
	public static Boolean isNumeric(String text) {
		try {
			Double.parseDouble(text);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}
