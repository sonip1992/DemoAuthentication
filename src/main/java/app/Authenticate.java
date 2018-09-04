package app;

public class Authenticate {
	
	public Authenticate() {
		
	}
	
	public boolean isValid(String value, String type) {
		boolean isValid = false;
		if(type.equals("bc")) {
			isValid = isBarcodeValid(value, type);
		} else {
			isValid = isQRValid(value, type);
		}
		
		return isValid;
	}
	
	private boolean isBarcodeValid(String value, String type) {
		boolean isBarcodeValid = false;
		ValidEntries ve = new ValidEntries(type);
		String validBC[] = ve.getValidBC();
		
		for(String vbc: validBC) {
			if(value.equals(vbc)) {
				isBarcodeValid = true;
			}
		}
		
		System.out.println("Is Barcode " + value + "valid: " + isBarcodeValid);
		
		return isBarcodeValid;
	}
	
	private boolean isQRValid(String value, String type) {
		boolean isQRValid = false;
		ValidEntries ve = new ValidEntries(type);
		String validQR[] = ve.getValidQR();
		
		for(String vbc: validQR) {
			if(value.equals(vbc)) {
				isQRValid = true;
			}
		}
		
		System.out.println("Is QR " + value + "valid: " + isQRValid);
		
		return isQRValid;
	}
}
