package vttp5.paf.day24.model.exception;

public class BookNotFoundException extends RuntimeException{
    
    public BookNotFoundException()
    {

    }

    public BookNotFoundException(String message)
    {
        super(message);
    }

    public BookNotFoundException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}


