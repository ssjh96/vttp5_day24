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
public class GlobalExceptionHandler {
    
    // Global Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception ex, HttpServletRequest request, HttpServletResponse response)
    {
        ErrorMessage message = new ErrorMessage( // Creates a custom JSON Response
                                                response.getStatus(), // HTTP Status Code
                                                ex.getMessage(), // Exception Msg
                                                new Date(), // TImestamp
                                                request.getRequestURI()); // Request URL

        // {
        //  "status":400,
        //  "message":"blah blah blah"
        //  "timeStamp":"blah blah blah"
        //  "endPoint":"/api/transfer"
        // }

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR); 
    }

    // Account Details Exceptions
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleAccountNotFoundException(AccountNotFoundException ex, HttpServletRequest request, HttpServletResponse response)
    {
        ErrorMessage message = new ErrorMessage(404, ex.getMessage(), new Date(), request.getRequestURI());

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR); // Should return HttpStatus.NOT_FOUND, 
        // HttpStatus.INTERNAL_SERVER_ERROR explicitly set the response HTTP status to 500 (INTERNAL_SERVER_ERROR) but we created the errormessage status as 404 which is misleading
    }

    // MOST CORRECT EXAMPLE

    // arg: HttpServletRequest for information about the request that caused the exception, request.getRequestURI(), request header: request.getHeader("Authorization"), client info: request.getRemoteAddr()

    // Arg: HttpServletResponse response is usually redundant because Http status and body are set by responseentity. It allows manual set HttpStatusCode (rare in @ExceptionHandler since ResponseEntity handles this), access or modify response-specific attributes, e.g.  response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Set status manually. response.getWriter().write("An error occurred"); // Write a simple response body

    @ExceptionHandler(AccountInactiveException.class)
    public ResponseEntity<ErrorMessage> handleAccountInactiveException(AccountInactiveException ex, HttpServletRequest request, HttpServletResponse response)
    {
        HttpStatus status = HttpStatus.BAD_REQUEST; // Should set status explicitly in case defaulted to 200

        ErrorMessage message = new ErrorMessage(status.value(), // Use the explicit HTTP status
                                ex.getMessage(), // The exception message
                                new Date(), // Current timestamp
                                request.getRequestURI()); // The endpoint that caused the exception

        return new ResponseEntity<>(message, status);
    }


    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ErrorMessage> handleInsufficientBalanceException(InsufficientBalanceException ex, HttpServletRequest request, HttpServletResponse response)
    {
        ErrorMessage message = new ErrorMessage(response.getStatus(), ex.getMessage(), new Date(), request.getRequestURI());

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}

// Example
// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(AccountNotFoundException.class)
//     public ResponseEntity<String> handleAccountNotFoundException(AccountNotFoundException ex) {
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//     }
// }

// 400 = bad request = client made a bad request appropriate for cases like inactive acc
// 404 = notfound = resource not found
// 403 = forbidden = access-related
// 500 internal server error = server side errors