/**
 * Exception for invalid social insurance number
 * as a subclass of Exception, and so a calling 
 * program must use try/catch or a throws clause.
 * 
 * we want a checked exception: so extend Exception
 */
public class InvalidSINException extends Exception
{
    private String sin;
    /**
     * Constructor that accepts a SIN
     */
    public InvalidSINException(String s)
    {
        sin = s;
    }
    /**
     * getter for SIN that caused the exception
     */
    public String getSin(){
        return sin;
    }
}
