package vttp5.paf.day24.model.exception;


// Custom error exceptions
// Exceptions here pertain to the model?

// right-cick definition -  accountnotfoundexception > runtimeexceptopn > exception > throwable > serialisable 
public class AccountNotFoundException extends RuntimeException
{
    public AccountNotFoundException()
    {

    }

    public AccountNotFoundException(String message)
    {
        super(message);
    }

    // Throwable to implement it to throw at function level?
    public AccountNotFoundException(String message, Throwable throwable)
    {
        super (message, throwable);
    }
}
