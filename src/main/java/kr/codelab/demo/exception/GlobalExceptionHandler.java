package kr.codelab.demo.exception;

import kr.codelab.demo.code.ErrorMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataException.class)
    public ResponseEntity<?> handleDataException(DataException e) {
        ErrorMsg errorMsg = new ErrorMsg();

        errorMsg.setCode(e.getCode());
        errorMsg.setMessage(e.getMessage());

        return new ResponseEntity<>(errorMsg, HttpStatus.OK);
    }
}
