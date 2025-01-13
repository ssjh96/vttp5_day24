package vttp5.paf.day24.model.exception;


// Custom error exceptions

// right-cick definition -  accountnotfoundexception > runtimeexceptopn > exception > throwable > serialisable 
public class AccountInactiveException extends RuntimeException
{
    public AccountInactiveException()
    {

    }

    public AccountInactiveException(String message)
    {
        super(message);
    }

    // Throwable to implement it to throw at function level?
    public AccountInactiveException(String message, Throwable throwable)
    {
        super (message, throwable);
    }
}
