/*
 * EmptyCollectionException.java -- throws a exception
 * Jason Melnik
 * CSC - 121
 * 3/26/2019
 */
public class EmptyCollectionException extends RuntimeException
{
	public EmptyCollectionException(String collection)
	{
		super("The " + collection + " is empty.");
	}
}
