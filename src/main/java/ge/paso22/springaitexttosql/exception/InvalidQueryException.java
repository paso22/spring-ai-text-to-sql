package ge.paso22.springaitexttosql.exception;

public class InvalidQueryException extends RuntimeException {

  public InvalidQueryException(String message) {
    super(message);
  }
}
