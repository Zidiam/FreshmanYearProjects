/*
 * ElementNotFoundException.java -- throws a exception
 * Jason Melnik
 * CSC - 121
 * 3/26/2019
 */
public class ElementNotFoundException extends RuntimeException{
	public ElementNotFoundException(String collection) {
		super("The " + collection + " is empty.");
	}
}
