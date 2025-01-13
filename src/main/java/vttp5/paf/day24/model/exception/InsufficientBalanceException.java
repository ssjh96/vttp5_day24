package vttp5.paf.day24.model.exception;


// Custom error exceptions

// right-cick definition -  accountnotfoundexception > runtimeexceptopn > exception > throwable > serialisable 
public class InsufficientBalanceException extends RuntimeException
{
    public InsufficientBalanceException()
    {

    }

    public InsufficientBalanceException(String message)
    {
        super(message);
    }

    // Throwable to implement it to throw at function level?
    public InsufficientBalanceException(String message, Throwable throwable)
    {
        super (message, throwable);
    }
}
