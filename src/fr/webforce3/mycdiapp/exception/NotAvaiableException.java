package fr.webforce3.mycdiapp.exception;

public class NotAvaiableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		String message = super.getMessage();
		message = "This product is not avaiable";
		return message;
	}
	
	

}
