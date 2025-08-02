package ge.paso22.springaitexttosql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(InvalidQueryException.class)
  public ResponseEntity<String> handleInvalidQueryException(InvalidQueryException ex) {
    return new ResponseEntity<>(
        "Given query is invalid - " + ex.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(PlayersNotFoundException.class)
  public ResponseEntity<String> handlePlayersNotFoundException(PlayersNotFoundException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }
}
