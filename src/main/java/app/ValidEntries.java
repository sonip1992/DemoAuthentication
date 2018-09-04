package app;

public class ValidEntries {
	private static String validBC[];
	private static String validQR[];
	
	public ValidEntries(String type) {
		if(type.equals("bc")) {
			validBC = new String[] {"1234567890", "1122334455", "1212121212"};
		} else {
			validQR = new String[] {"1234567890", "1122334455", "1212121212"};
		}
	}
	
	public String[] getValidBC() {
		return validBC;
	}
	
	public String[] getValidQR() {
		return validQR;
	}
}
