package vaibhav.framework.exceptionhandling;

public class InvalidLocatorType extends RuntimeException{
	/*static String message;
	static {
		message = "Invalid Locator provided accepted Types are"+ "xpath,css,id,name,linktext,partiallinktext,tagname";		
	}*/
	public InvalidLocatorType() {
		super( "Invalid Locator provided accepted Types are :-"+ "xpath,css,id,name,linktext,partiallinktext,tagname");				
	}
}
