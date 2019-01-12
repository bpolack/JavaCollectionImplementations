package jsjf.exceptions;

/**
 * Represents the situation in which a collection is full.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class FullCollectionException extends RuntimeException
{
    /**
     * Sets up this exception with an appropriate message.
     * @param collection the name of the collection
     */
    public FullCollectionException(String collection)
    {
        super("The " + collection + " is full.");
    }
}
