package vttp5.paf.day24.exception;

import java.util.Date;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vttp5.paf.day24.model.exception.AccountInactiveException;
import vttp5.paf.day24.model.exception.ErrorMessage;
import vttp5.paf.day24.model.exception.InsufficientBalanceException;

@RestControllerAdvice
public class GkibakExceptionHandler {
    
    // Global Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception ex, HttpServletRequest request, HttpServletResponse response)
    {
        ErrorMessage message = new ErrorMessage(response.getStatus(), ex.getMessage(), new Date(), request.getRequestURI());

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Account Details Exceptions
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleAccountNotFoundException(AccountNotFoundException ex, HttpServletRequest request, HttpServletResponse response)
    {
        ErrorMessage message = new ErrorMessage(404, ex.getMessage(), new Date(), request.getRequestURI());

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccountInactiveException.class)
    public ResponseEntity<ErrorMessage> handleAccountInactiveException(AccountInactiveException ex, HttpServletRequest request, HttpServletResponse response)
    {
        ErrorMessage message = new ErrorMessage(response.getStatus(), ex.getMessage(), new Date(), request.getRequestURI());

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ErrorMessage> handleInsufficientBalanceException(InsufficientBalanceException ex, HttpServletRequest request, HttpServletResponse response)
    {
        ErrorMessage message = new ErrorMessage(response.getStatus(), ex.getMessage(), new Date(), request.getRequestURI());

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
